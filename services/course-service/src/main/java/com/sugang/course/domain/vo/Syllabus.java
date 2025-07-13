package com.sugang.course.domain.vo;

import java.util.Objects;

public record Syllabus(String content) {

  public Syllabus {
    Objects.requireNonNull(content, "강의 계획서 내용은 null일 수 없습니다.");

    if (content.isBlank()) {
      throw new IllegalArgumentException("강의 계획서 내용은 비어 있을 수 없습니다.");
    }
  }
}
