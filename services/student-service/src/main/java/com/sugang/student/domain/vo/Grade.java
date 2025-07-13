package com.sugang.student.domain.vo;

public class Grade {
    private final int value;

    public Grade(int value) {
        if (value < 1 || value > 4) {
            throw new IllegalArgumentException("Grade must be between 1 and 4.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
