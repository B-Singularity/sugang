package com.sugang.student.application.port.in;

public interface AuthenticateStudentUseCase {
    boolean authenticate(AuthenticateStudentCommand command);
}
