package com.sugang.student.domain.vo;

import java.util.Objects;

public class StudentId {
    private final String value;

    public StudentId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Student ID must not be blank.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentId)) return false;
        StudentId that = (StudentId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
