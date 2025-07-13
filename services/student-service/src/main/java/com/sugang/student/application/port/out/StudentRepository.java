package com.sugang.student.application.port.out;

import com.sugang.student.domain.aggregate.Student;
import com.sugang.student.domain.vo.StudentId;

import java.util.Optional;

// save() 새로운 학생을 db에 저장
// findById 로그인 등에서 학생 조회 
public interface StudentRepository {
    void save(Student student);
    Optional<Student> findById(StudentId id);
}
