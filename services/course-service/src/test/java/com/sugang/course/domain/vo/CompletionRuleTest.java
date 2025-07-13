package com.sugang.course.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("CompletionRule vo 단위 테스트")
class CompletionRuleTest {

    @DisplayName("계약: 유효한 departmentId, courseType으로 객체를 생성할 수 있다.")
    @Test
    void create_valid_completion_rule() {
        var departmentId = new DepartmentId("CS");
        var courseType = CourseType.MAJOR_REQUIRED;

        assertDoesNotThrow(() -> new CompletionRule(departmentId, courseType));
    }

    @Test
    @DisplayName("계약: 학과 ID가 null이면 NullPointException 예외가 발생한다.")
    void throws_exception_when_dapartmentId_is_null() {
        DepartmentId departmentId = null;
        var courseType = CourseType.MAJOR_REQUIRED;

        assertThrows(NullPointerException.class, () -> new CompletionRule(departmentId, courseType));
    }

    @Test
    @DisplayName("계약: 모든 필드 값이 같으면 두 객체는 동일한 것으로 간주한다.")
    void it_considers_two_objects_equal_if_all_fields_are_the_same() {
        var ruleA = new CompletionRule(new DepartmentId("CS"), CourseType.MAJOR_REQUIRED);
        var ruleB = new CompletionRule(new DepartmentId("CS"), CourseType.MAJOR_REQUIRED);

        assertThat(ruleA)
                .isEqualTo(ruleB)
                .hasSameHashCodeAs(ruleB);
    }

    @Test
    @DisplayName("계약: 필드 값이 하나라도 다르면 두 객체는 다른 것으로 간주한다.")
    void it_considers_two_objects_not_equal_if_any_field_is_different() {
        var ruleA = new CompletionRule(new DepartmentId("CS"), CourseType.MAJOR_REQUIRED);
        var ruleB = new CompletionRule(new DepartmentId("ME"), CourseType.MAJOR_REQUIRED);

        assertThat(ruleA).isNotEqualTo(ruleB);
    }
}
