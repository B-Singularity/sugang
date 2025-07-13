package com.sugang.course.application.service;

import com.sugang.course.adapter.out.persistence.mapper.CourseMapper;
import com.sugang.course.adapter.out.persistence.mapper.OpenedCourseMapper;
import com.sugang.course.application.port.in.LoadCourseQuery;
import com.sugang.course.application.port.in.ManageCourseUseCase;
import com.sugang.course.application.port.out.CourseRepositoryPort;
import com.sugang.course.application.port.out.OpenedCourseRepositoryPort;
import com.sugang.course.domain.aggregate.OpenedCourse;
import com.sugang.course.domain.vo.OpenedCourseId;
import com.sugang.course.global.exception.CourseNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseService implements ManageCourseUseCase, LoadCourseQuery {

  private final CourseRepositoryPort courseRepositoryPort;
  private final OpenedCourseRepositoryPort openedCourseRepositoryPort;
  private final CourseMapper courseMapper;
  private final OpenedCourseMapper openedCourseMapper;

  @Override
  @Transactional
  public OpenedCourse createOpenedCourse(ManageCourseUseCase.CreateOpenedCourseCommand command) {
    OpenedCourseId newId = OpenedCourseId.generateCourseId();
    OpenedCourse newOpenedCourse = openedCourseMapper.toDomain(command, newId);
    return openedCourseRepositoryPort.save(newOpenedCourse);
  }

  @Override
  @Transactional
  public OpenedCourse updateOpenedCourse(
      OpenedCourseId id, ManageCourseUseCase.UpdateOpenedCourseCommand command) {
    OpenedCourse course = loadCourse(id);
    course.updateDetails(command);
    return openedCourseRepositoryPort.save(course);
  }

  @Override
  @Transactional
  public void deleteOpenedCourse(OpenedCourseId id) {
    openedCourseRepositoryPort.deleteById(id);
  }

  @Override
  public OpenedCourse loadCourse(OpenedCourseId openedCourseId) {
    return openedCourseRepositoryPort
        .findById(openedCourseId)
        .orElseThrow(() -> new CourseNotFoundException(openedCourseId));
  }

  @Override
  public List<OpenedCourse> searchOpenedCourse(CourseSearchCommand command) {
    return openedCourseRepositoryPort.search(command);
  }
}
