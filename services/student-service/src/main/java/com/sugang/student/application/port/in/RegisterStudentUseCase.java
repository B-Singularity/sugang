package com.sugang.student.application.port.in;

import com.sugang.student.domain.aggregate.Student;

public interface RegisterStudentUseCase {
    Student register(RegisterStudentCommand command);
}
