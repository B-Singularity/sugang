package com.sugang.course.global.exception;

import com.sugang.course.domain.vo.CourseCode;
import com.sugang.course.domain.vo.OpenedCourseId;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(OpenedCourseId openedCourseId) {
        super("ID에 해당하는 강의를 찾을 수 없습니다: " + openedCourseId.openedCourseId());
    }

    public CourseNotFoundException(CourseCode courseCode) {
        super("과목코드에 해당하는 강의를 찾을 수 없습니다: " + courseCode.value());
    }
}
