package com.sugang.course.adapter.out.persistence;

import com.sugang.course.adapter.out.persistence.mapper.CourseMapper;
import com.sugang.course.adapter.out.persistence.repository.CourseJpaRepository;
import com.sugang.course.application.port.out.CourseRepositoryPort;
import com.sugang.course.domain.aggregate.Course;
import com.sugang.course.domain.vo.CourseCode;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CoursePersistenceAdapter implements CourseRepositoryPort {

  private final CourseJpaRepository courseJpaRepository;
  private final CourseMapper courseMapper;

  @Override
  public Course save(Course course) {
    var entity = courseMapper.toEntity(course);
    var saveEntity = courseJpaRepository.save(entity);
    return courseMapper.toDomain(saveEntity);
  }

  @Override
  public Optional<Course> findByCourseCode(CourseCode courseCode) {
    return courseJpaRepository.findById(courseCode.value()).map(courseMapper::toDomain);
  }

  @Override
  public void deleteByCourseCode(CourseCode courseCode) {
    courseJpaRepository.deleteById(courseCode.value());
  }
}
