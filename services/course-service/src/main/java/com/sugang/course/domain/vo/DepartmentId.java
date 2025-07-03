package com.sugang.course.domain.vo;
import java.util.Objects;
import java.util.regex.Pattern;

public record DepartmentId(String id) {
    private static final Pattern VALID_PATTERN = Pattern.compile("^[A-Z]{2,6}$");

    public DepartmentId {
        Objects.requireNonNull(id, "학과 ID는 null일 수 없습니다.");

        if (id.isBlank()) {
            throw new IllegalArgumentException("학과 ID는 비어 있을 수 없습니다.");
        }

        if (!VALID_PATTERN.matcher(id).matches()) {
            throw new IllegalArgumentException("학과 ID 형식이 올바르지 않습니다. (예: CS, MECH)");
        }
    }
}
