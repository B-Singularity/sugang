package com.sugang.course.application.port.in;

import com.sugang.course.domain.aggregate.OpenedCourse;
import com.sugang.course.domain.vo.*;
import java.util.Set;

public interface ManageCourseUseCase {

    OpenedCourse createOpenedCourse(CreateCourseCommand command);

    OpenedCourse updateOpenedCourse(OpenedCourseId id, UpdateOpenedCourseCommand command);

    void deleteOpenedCourse(OpenedCourseId id);

    record CreateCourseCommand(
            CourseCode courseCode,
            Semester semester,
            Set<Instructor> instructors,
            ClassSchedule classSchedule,
            Quota quota,
            Syllabus syllabus
    ) {}

    record UpdateOpenedCourseCommand(
            String instructor,
            int capacity
    ) {}
}
