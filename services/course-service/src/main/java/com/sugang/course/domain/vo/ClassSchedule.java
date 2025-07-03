package com.sugang.course.domain.vo;


import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public record ClassSchedule(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {

    public ClassSchedule {
        Objects.requireNonNull(dayOfWeek, "요일은 필수입니다.");
        Objects.requireNonNull(startTime, "시작 시간은 필수입니다.");
        Objects.requireNonNull(endTime, "종료 시간은 필수입니다.");

        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            throw new IllegalArgumentException("시작 시간은 종료 시간보다 빨라야 합니다.");
        }
    }

    public boolean isConflict(ClassSchedule other) {
        if (!this.dayOfWeek.equals(other.dayOfWeek)) {
            return false;
        }

        return this.startTime.isBefore(other.endTime) && other.startTime.isBefore(this.endTime);
    }
}

