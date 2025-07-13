package com.sugang.course.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CourseCode Vo 단위 테스트")
class CourseCodeTest {

    @DisplayName("계약: 유효한 값을 가지면 객체가 생성되어야 한다.")
    @Test
    void create_course_code_with_valid_value() {
        assertDoesNotThrow(() -> new CourseCode("CS101"));
    }

    @DisplayName("계약: null이면 IllegalArgumentException 예외를 처리해야한다.")
    @Test
    void throw_exception_when_value_is_null() {
        assertThrows(NullPointerException.class, () -> new CourseCode(null));
    }

    @DisplayName("계약: 과목 코드가 비어있으면 IllegalArgumentException 예외를 처리해야한다.")
    @Test
    void throw_exception_when_value_is_blank() {
        assertThrows(IllegalArgumentException.class, () -> new CourseCode(""));
    }

    @DisplayName("계약: 과목 코드 형식이 올바르지 않으면 IllegalArgumentException 예외를 처리해야한다.")
    @Test
    void throw_exception_when_value_is_invalid() {
        assertThrows(IllegalArgumentException.class, () -> new CourseCode("CS101033"));
    }

    @DisplayName("계약: 같은 값을 가질 경우 같은 객체여야 한다.")
    @Test
    void it_considers_two_objects_equal_if_all_fields_are_the_same() {
        var codeA = new CourseCode("CS101");
        var codeB = new CourseCode("CS101");
        assertThat(codeA)
                .isEqualTo(codeB)
                .hasSameHashCodeAs(codeB);
    }

}
