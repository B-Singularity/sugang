package com.sugang.course.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ClassSchedule 값 객체(VO) 단위 테스트")
class ClassScheduleTest {

    @Test
    @DisplayName("계약: 유요한 요일, 시작/종료 시간으로 객체를 생성할 수 있다.")
    void create_schedule_with_valid_time() {
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        LocalTime startTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(11, 0);

        assertDoesNotThrow(() -> new ClassSchedule(dayOfWeek, startTime, endTime));
    }

    @Test
    @DisplayName("계약: 시작 시간이 종료 시간보다 늦으면 예외가 발생한다.")
    void throw_exception_when_start_time_is_after_end_time() {
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        LocalTime startTime = LocalTime.of(11, 0);
        LocalTime endTime = LocalTime.of(10, 0);

        assertThrows(IllegalArgumentException.class, () -> new ClassSchedule(dayOfWeek, startTime, endTime));
    }

    @Test
    @DisplayName("계약: 요일이 다르면 시간이 겹쳐도 false를 반환한다.")
    void return_false_when_days_are_different() {
        var sheduleA = new ClassSchedule(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 0));
        var scheduleB = new ClassSchedule(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(11, 0));

        boolean isConflict = sheduleA.isConflict(scheduleB);

        assertFalse(isConflict);
    }

    @Test
    @DisplayName("계약: 한 강의가 끝나는 시간과 다른 강의가 시작하는 시간이 같으면 false를 반환한다.")
    void it_returns_false_on_boundary_condition() {
        // given
        var scheduleA = new ClassSchedule(DayOfWeek.FRIDAY, LocalTime.of(9, 0), LocalTime.of(11, 0));
        var scheduleB = new ClassSchedule(DayOfWeek.FRIDAY, LocalTime.of(11, 0), LocalTime.of(13, 0));

        // when
        boolean isConflict = scheduleA.isConflict(scheduleB);

        // then
        assertThat(isConflict).isFalse();
    }

    @Test
    @DisplayName("계약: 두 강의 시간이 부분적으로 겹치면 true를 반환한다.")
    void it_returns_true_when_partially_overlapped() {
        // given
        var scheduleA = new ClassSchedule(DayOfWeek.WEDNESDAY, LocalTime.of(13, 0), LocalTime.of(15, 0));
        var scheduleB = new ClassSchedule(DayOfWeek.WEDNESDAY, LocalTime.of(14, 0), LocalTime.of(16, 0));

        // when
        boolean isConflict = scheduleA.isConflict(scheduleB);

        // then
        assertThat(isConflict).isTrue();
    }

    @Test
    @DisplayName("계약: 한 강의 시간이 다른 강의 시간을 완전히 포함하면 true를 반환한다.")
    void it_returns_true_when_one_schedule_contains_another() {
        // given
        var scheduleA = new ClassSchedule(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(12, 0));
        var scheduleB = new ClassSchedule(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 0));

        // when
        boolean isConflict = scheduleA.isConflict(scheduleB);

        // then
        assertThat(isConflict).isTrue();
    }

    @Test
    @DisplayName("계약: 값이 다르면 다른 객체로 취급한다.")
    void it_considers_two_objects_not_equal_if_any_field_is_different() {
        var scheduleA = new ClassSchedule(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(12, 0));
        var scheduleB = new ClassSchedule(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 0));

        assertThat(scheduleA).isNotEqualTo(scheduleB);
    }


}