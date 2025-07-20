package com.sugang.course.application.port.in;

import com.sugang.course.domain.aggregate.Course;
import com.sugang.course.domain.vo.CompletionRule;
import com.sugang.course.domain.vo.CourseCode;

import java.util.Set;

public interface ManageCourseUseCase {

    Course createCourse(CreateCourseCommand command);

    Course updateCourse(UpdateCourseCommand commnad);

    void deleteCourse(CourseCode courseCode);

    record CreateCourseCommand(
            CourseCode courseCode,
            String title,
            String description,
            Set<CourseCode> prerequisites,
            Set<CompletionRule> completionRules){}

    record UpdateCourseCommand(
            CourseCode courseCode,
            String title,
            String description,
            Set<CourseCode> prerequisites,
            Set<CompletionRule> completionRules){}
}
