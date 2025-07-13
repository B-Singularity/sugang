package com.sugang.course.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class ClassSchedule {

  private DayOfWeek dayOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;

  public ClassSchedule(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
    Objects.requireNonNull(dayOfWeek, "요일은 필수입니다.");
    Objects.requireNonNull(startTime, "시작 시간은 필수입니다.");
    Objects.requireNonNull(endTime, "종료 시간은 필수입니다.");

    if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
      throw new IllegalArgumentException("시작 시간은 종료 시간보다 빨라야 합니다.");
    }
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }
  public boolean isConflict(ClassSchedule other) {
    if (!this.dayOfWeek.equals(other.dayOfWeek)) {
      return false;
    }

    return this.startTime.isBefore(other.endTime) && other.startTime.isBefore(this.endTime);
  }
}

