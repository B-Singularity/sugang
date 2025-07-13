package com.sugang.student.application.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sugang.student.application.port.out.StudentRepository;
import com.sugang.student.application.port.out.PasswordEncoderPort;

@Configuration
public class StudentServiceConfig {

    @Bean
    public StudentService studentService(StudentRepository studentRepository, PasswordEncoderPort passwordEncoder) {
        return new StudentService(studentRepository, passwordEncoder);
    }
}
