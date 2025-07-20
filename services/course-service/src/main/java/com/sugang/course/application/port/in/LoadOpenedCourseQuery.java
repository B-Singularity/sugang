package com.sugang.course.application.port.in;

import com.sugang.course.domain.aggregate.OpenedCourse;
import com.sugang.course.domain.vo.OpenedCourseId;
import java.util.List;

public interface LoadOpenedCourseQuery {

  OpenedCourse loadOpendedCourse(OpenedCourseId openedCourseId);

  List<OpenedCourse> searchOpenedCourse(OpendedCourseSearchCommand command);

  record OpendedCourseSearchCommand(String departmentId, String courseType, String query) {}
}
