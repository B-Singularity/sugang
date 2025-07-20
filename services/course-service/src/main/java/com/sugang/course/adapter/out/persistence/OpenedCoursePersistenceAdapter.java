package com.sugang.course.adapter.out.persistence;

import com.sugang.course.adapter.out.persistence.mapper.OpenedCourseMapper;
import com.sugang.course.adapter.out.persistence.repository.OpenedCourseJpaRepository;
import com.sugang.course.application.port.in.LoadOpenedCourseQuery;
import com.sugang.course.application.port.out.OpenedCourseRepositoryPort;
import com.sugang.course.domain.aggregate.OpenedCourse;
import com.sugang.course.domain.vo.OpenedCourseId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OpenedCoursePersistenceAdapter implements OpenedCourseRepositoryPort {

  private final OpenedCourseJpaRepository jpaRepository;
  private final OpenedCourseMapper mapper;

  @Override
  public OpenedCourse save(OpenedCourse openedCourse) {
    var entity = mapper.toEntity(openedCourse);
    var savedEntity = jpaRepository.save(entity);
    return mapper.toDomain(savedEntity);
  }

  @Override
  public Optional<OpenedCourse> findById(OpenedCourseId openedCourseId) {
    // JpaRepository는 ID의 실제 타입(String)으로 조회해야 함
    return jpaRepository.findById(openedCourseId.openedCourseId()).map(mapper::toDomain);
  }

  @Override
  public void deleteById(OpenedCourseId openedCourseId) {
    jpaRepository.deleteById(openedCourseId.openedCourseId());
  }

  @Override
  public List<OpenedCourse> searchOpenedCourse(LoadOpenedCourseQuery.OpendedCourseSearchCommand command) {
    // Querydsl로 구현한 커스텀 리포지토리의 search 메서드를 호출합니다.
    return jpaRepository.search(command).stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
  }
}
