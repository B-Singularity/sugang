package com.sugang.course.application.port.in;

import com.sugang.course.domain.aggregate.OpenedCourse;
import com.sugang.course.domain.vo.*;
import java.util.Set;

public interface ManageCourseUseCase {

  OpenedCourse createOpenedCourse(CreateOpenedCourseCommand command);

  OpenedCourse updateOpenedCourse(OpenedCourseId id, UpdateOpenedCourseCommand command);

  void deleteOpenedCourse(OpenedCourseId id);

  record CreateOpenedCourseCommand(
      CourseCode courseCode,
      Semester semester,
      Set<Instructor> instructors,
      ClassSchedule classSchedule,
      Quota quota,
      Syllabus syllabus) {}

  record UpdateOpenedCourseCommand(
      Set<Instructor> instructors,
      ClassSchedule classSchedule,
      int capacity, // Quota의 일부
      Syllabus syllabus) {}
}
