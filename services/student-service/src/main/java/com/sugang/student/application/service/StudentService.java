package com.sugang.student.application.service;

import com.sugang.student.application.port.in.RegisterStudentCommand;
import com.sugang.student.application.port.in.RegisterStudentUseCase;
import com.sugang.student.application.port.in.AuthenticateStudentCommand;
import com.sugang.student.application.port.in.AuthenticateStudentUseCase;
import com.sugang.student.application.port.out.PasswordEncoderPort;
import com.sugang.student.application.port.out.StudentRepository;
import com.sugang.student.domain.aggregate.Student;
import com.sugang.student.domain.vo.*;

import java.util.Optional;

// 실제 유스케이스 구현 클래스
// RegisterStudentUseCase => Student register() 메서드 구현
// AuthenticateStudentUseCase => boolean authenticate() 메서드 구현
// 즉 StudentService는 회원가입, 로그인 인증을 모두 구현한 유스케이스를 구현하는 클래스
public class StudentService implements RegisterStudentUseCase, AuthenticateStudentUseCase {

    private final StudentRepository studentRepository;
    private final PasswordEncoderPort passwordEncoder;

    // 생성자 주입
    public StudentService(StudentRepository studentRepository, PasswordEncoderPort passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 학생 등록 구현
    @Override
    public Student register(RegisterStudentCommand command) {
        // 1. VO 변환
        StudentId id = new StudentId(command.studentId());
        DepartmentId departmentId = command.departmentId();
        Grade grade = command.grade();

        // 2. 비밀번호 해싱
        String hashedPassword = passwordEncoder.encode(command.rawPassword());

        // 3. 도메인 객체 생성
        Student student = Student.register(id, command.name(), hashedPassword, departmentId, grade);

        // 4. 저장
        studentRepository.save(student);

        return student;
    }

    // 로그인 인증 구현
    @Override
    public boolean authenticate(AuthenticateStudentCommand command) {
        StudentId id = new StudentId(command.studentId());

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            return false;
        }

        Student student = optionalStudent.get();

        return passwordEncoder.matches(command.rawPassword(), student.getHashedPassword());
    }
}
