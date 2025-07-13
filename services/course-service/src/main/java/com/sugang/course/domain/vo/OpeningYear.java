package com.sugang.course.domain.vo;

import java.time.Year;

public record OpeningYear(int value) {

  public OpeningYear {
    int currentYear = Year.now().getValue();
    if (value < currentYear || value > currentYear + 2) {
      throw new IllegalArgumentException("개설 년도는 현재 년도와 향후 2년 내에서만 설정 가능합니다.");
    }
  }
}
