package com.sugang.course.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DepartmentId vo 단위 테스트")
class DepartmentIdTest {

    @DisplayName("계약: 유효한 값을 가지면 객체가 생성되어야 한다.")
    @Test
    void create_department_id_with_valid_value() {
        assertDoesNotThrow(() -> new DepartmentId("CS"));
    }

    @DisplayName("계약: 같은 값을 가지면 같은 객체다.")
    @Test
    void it_considers_two_objects_equal_if_all_fields_are_the_same() {
        var idA = new DepartmentId("CS");
        var idB = new DepartmentId("CS");
        assertThat(idA)
                .isEqualTo(idB)
                .hasSameHashCodeAs(idB);
    }

    @DisplayName("계약: 학과 ID가 Null 값을 가지면 예외를 발생시킨다.")
    @Test
    void throws_exception_when_department_id_is_null() {
        assertThrows(NullPointerException.class, () -> new DepartmentId(null));
    }

    @DisplayName("계약: 학과 ID가 blank 값을 가지면 예외를 발생시킨다.")
    @Test
    void throws_exception_when_department_id_is_blank() {
        assertThrows(IllegalArgumentException.class, () -> new DepartmentId(""));
    }

    @DisplayName("계약: 학과 ID 형식이 올바르지 않으면 예외를 발생시킨다.")
    @Test
    void throws_exception_when_department_id_is_invalid() {
        assertThrows(IllegalArgumentException.class, () -> new DepartmentId("CS101"));
    }

}
