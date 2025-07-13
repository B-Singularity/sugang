package com.sugang.course.application.port.out;

import com.sugang.course.domain.aggregate.Course;
import com.sugang.course.domain.vo.CourseCode;
import java.util.Optional;

public interface CourseRepositoryPort {
  Course save(Course course);

  Optional<Course> findByCourseCode(CourseCode courseCode);

  void deleteByCourseCode(CourseCode courseCode);
}
