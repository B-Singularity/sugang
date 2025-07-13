package com.sugang.student.domain.vo;

public enum StudentStatus {
    ACTIVE, // 재학 중인 상태(현재 수강 가능)
    INACTIVE, // 휴학 혹은 비활성화된 상태
    SUSPENDED, // 정학 등의 이유로 일시 정지된 상태
    GRADUATED // 졸업생
}
