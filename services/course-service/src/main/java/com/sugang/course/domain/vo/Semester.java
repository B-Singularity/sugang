package com.sugang.course.domain.vo;

import java.util.Objects;

public record Semester(OpeningYear openingYear, Term term) {

    public Semester {
        Objects.requireNonNull(openingYear, "년도는 필수입니다.");
        Objects.requireNonNull(term, "학기 정보는 필수입니다.");
    }

    @Override
    public String toString() {
        return openingYear.value() + "-" + term.getCode();
    }
}
