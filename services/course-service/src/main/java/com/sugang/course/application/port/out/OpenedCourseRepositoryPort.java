package com.sugang.course.application.port.out;

import com.sugang.course.application.port.in.LoadCourseQuery;
import com.sugang.course.domain.aggregate.OpenedCourse;
import com.sugang.course.domain.vo.OpenedCourseId;
import java.util.List;
import java.util.Optional;

public interface OpenedCourseRepositoryPort {
  OpenedCourse save(OpenedCourse openedCourse);

  Optional<OpenedCourse> findById(OpenedCourseId openedCourseId);

  void deleteById(OpenedCourseId openedCourseId);

  List<OpenedCourse> search(LoadCourseQuery.CourseSearchCommand command);
}
