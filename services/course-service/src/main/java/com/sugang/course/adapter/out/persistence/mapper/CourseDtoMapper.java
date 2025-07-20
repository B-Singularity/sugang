package com.sugang.course.adapter.out.persistence.mapper;

import com.sugang.course.adapter.in.web.dto.OpenedCourseResponse;
import com.sugang.course.domain.aggregate.Course;
import com.sugang.course.domain.aggregate.OpenedCourse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseDtoMapper {

    @Mapping(source = "openedCourse.openedCourseId.openedCourseId", target = "openedCourseId")
    @Mapping(source = "openedCourse.courseCode.value", target = "courseCode")
    @Mapping(source = "course.title", target = "title")
    @Mapping(source = "course.description", target = "description")
    @Mapping(source = "openedCourse.semester", target = "semester")
    @Mapping(source = "openedCourse.instructors", target = "instructors")
    @Mapping(source = "openedCourse.classSchedule", target = "classSchedule")
    @Mapping(source = "openedCourse.quota", target = "quota")
    @Mapping(source = "openedCourse.syllabus", target = "syllabus")
    OpenedCourseResponse toResponse(OpenedCourse openedCourse, Course course);
}
