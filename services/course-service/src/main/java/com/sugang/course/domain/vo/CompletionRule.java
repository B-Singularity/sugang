package com.sugang.course.domain.vo;

import java.util.Objects;

public record CompletionRule(DepartmentId departmentId, CourseType courseType) {
    public CompletionRule {
        Objects.requireNonNull(departmentId, "학과 ID는 null일 수 없습니다.");
        Objects.requireNonNull(courseType, "이수 구분은 null일 수 없습니다.");
    }

}
