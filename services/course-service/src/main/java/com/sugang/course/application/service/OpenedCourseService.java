package com.sugang.course.application.service;

import com.sugang.course.adapter.out.persistence.mapper.CourseMapper;
import com.sugang.course.adapter.out.persistence.mapper.OpenedCourseMapper;
import com.sugang.course.application.port.in.LoadOpenedCourseQuery;
import com.sugang.course.application.port.in.ManageOpenedCourseUseCase;
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
public class OpenedCourseService implements ManageOpenedCourseUseCase, LoadOpenedCourseQuery{

  private final CourseRepositoryPort courseRepositoryPort;
  private final OpenedCourseRepositoryPort openedCourseRepositoryPort;
  private final CourseMapper courseMapper;
  private final OpenedCourseMapper openedCourseMapper;

  @Override
  @Transactional
  public OpenedCourse createOpenedCourse(ManageOpenedCourseUseCase.CreateOpenedCourseCommand command) {
    OpenedCourseId newId = OpenedCourseId.generateCourseId();
    OpenedCourse newOpenedCourse = openedCourseMapper.toDomain(command, newId);
    return openedCourseRepositoryPort.save(newOpenedCourse);
  }

  @Override
  @Transactional
  public OpenedCourse updateOpenedCourse(
      OpenedCourseId openedCourseId, ManageOpenedCourseUseCase.UpdateOpenedCourseCommand command) {
    OpenedCourse course = loadOpendedCourse(openedCourseId);
    course.updateDetails(command);
    return openedCourseRepositoryPort.save(course);
  }

  @Override
  @Transactional
  public void deleteOpenedCourse(OpenedCourseId openedCourseId) {
    openedCourseRepositoryPort.deleteById(openedCourseId);
  }

  public OpenedCourse loadOpendedCourse(OpenedCourseId openedCourseId) {
    return openedCourseRepositoryPort
        .findById(openedCourseId)
        .orElseThrow(() -> new CourseNotFoundException(openedCourseId));
  }

  @Override
  public List<OpenedCourse> searchOpenedCourse(OpendedCourseSearchCommand command) {
    return openedCourseRepositoryPort.searchOpenedCourse(command);
  }


}
