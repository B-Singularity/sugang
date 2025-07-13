package com.sugang.course.domain.vo;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Semester {

  private int year;
  @Enumerated(EnumType.STRING)
  private Term term;

  public Semester(int yearValue, Term term) {
    if (year < Year.now().getValue()) {
      throw new IllegalArgumentException("과거 년도의 학기는 생성할 수 없습니다.");
    }
    Objects.requireNonNull(term, "학기 정보는 필수입니다.");
    Objects.requireNonNull(year, "년도 정보는 필수입니다.");

    this.year = yearValue;
    this.term = term;
  }
}
