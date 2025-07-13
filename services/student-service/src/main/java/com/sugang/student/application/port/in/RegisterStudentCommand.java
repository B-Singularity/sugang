package com.sugang.student.application.port.in;

import com.sugang.student.domain.vo.DepartmentId;
import com.sugang.student.domain.vo.Grade;

public record RegisterStudentCommand(
        String studentId,
        String name,
        String rawPassword,
        DepartmentId departmentId,
        Grade grade
) {}
