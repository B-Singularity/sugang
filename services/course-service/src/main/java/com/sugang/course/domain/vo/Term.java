package com.sugang.course.domain.vo;

public enum Term {
  FISRT("1"),
  SECOND("2"),
  SUMMER("S"),
  WINTER("W");

  private final String code;

  Term(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
