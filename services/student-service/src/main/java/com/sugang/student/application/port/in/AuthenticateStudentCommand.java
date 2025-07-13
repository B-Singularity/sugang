package com.sugang.student.application.port.in;

public record AuthenticateStudentCommand(
        String studentId,
        String rawPassword
) {}
