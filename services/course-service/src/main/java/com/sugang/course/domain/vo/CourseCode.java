package com.sugang.course.domain.vo;

import java.util.Objects;
import java.util.regex.Pattern;

public record CourseCode(String value) {

    private static final Pattern VALID_PATTERN = Pattern.compile("^[A-Z]{2,3}\\d{3,4}$");

    public CourseCode {
        Objects.requireNonNull(value, "과목 코드는 null일 수 없습니다.");

        if (value.isBlank()) {
            throw new IllegalArgumentException("과목 코드는 비워있을 수 없습니다.");
        }

        if (!VALID_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("과목 코드 형식이 올바르지 않습니다. (예: CS101)");
        }
    }
}
