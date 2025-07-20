package com.sugang.course.application.port.in;

import com.sugang.course.domain.aggregate.Course;
import com.sugang.course.domain.vo.CourseCode;

public interface LoadCourseCatalogQuery {
    Course loadCourse(CourseCode courseCode);
}
