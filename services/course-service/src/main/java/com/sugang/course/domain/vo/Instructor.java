package com.sugang.course.domain.vo;

import java.util.Objects;

public record Instructor(String instructorId, String instructorName) {
  public Instructor {
    Objects.requireNonNull(instructorId, "강사 ID는 필수입니다.");
    Objects.requireNonNull(instructorName, "강사 이름은 필수입니다.");
  }
}
