package com.sugang.course.application.port.in;

import com.sugang.course.domain.aggregate.OpenedCourse;
import com.sugang.course.domain.vo.OpenedCourseId;
import java.util.List;

public interface LoadCourseQuery {

  OpenedCourse loadCourse(OpenedCourseId openedCourseId);

  List<OpenedCourse> searchOpenedCourse(CourseSearchCommand command);

  record CourseSearchCommand(String departmentId, String courseType, String query) {}
}
