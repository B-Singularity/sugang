package com.sugang.student.domain.vo;

import java.util.Objects;

public class DepartmentId {
    private final String value;

    public DepartmentId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Department ID must not be blank.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentId)) return false;
        DepartmentId that = (DepartmentId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
