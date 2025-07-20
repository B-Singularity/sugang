package com.sugang.course.adapter.in.web.dto;

import com.sugang.course.domain.vo.*;

import java.util.Set;

public record OpenedCourseDetailResponse(
        String openedCourseId,
        String courseCode,
        String title,
        String description,
        Semester semester,
        Set<Instructor> instructors,
        ClassSchedule classSchedule,
        Quota quota,
        Syllabus syllabus
) {}
