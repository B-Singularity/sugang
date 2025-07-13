package com.sugang.student.domain.aggregate;

import com.sugang.student.domain.vo.*;

public class Student {
    private final StudentId id;
    private final String name;
    private final String hashedPassword;
    private final DepartmentId departmentId;
    private final Grade grade;
    private final StudentStatus status;

    private Student(StudentId id, String name, String hashedPassword,
                    DepartmentId departmentId, Grade grade, StudentStatus status) {
        this.id = id;
        this.name = name;
        this.hashedPassword = hashedPassword;
        this.departmentId = departmentId;
        this.grade = grade;
        this.status = status;
    }

    public static Student register(StudentId id, String name, String hashedPassword,
                                   DepartmentId departmentId, Grade grade) {
        return new Student(id, name, hashedPassword, departmentId, grade, StudentStatus.ACTIVE);
    }

    public boolean authenticate(String hashedPasswordToCompare) {
        return this.hashedPassword.equals(hashedPasswordToCompare);
    }

    // Getter들 필요 시 추가
    public StudentId getId() { return id; }
    public String getName() { return name; }
    public String getHashedPassword() { return hashedPassword; }
    public DepartmentId getDepartmentId() { return departmentId; }
    public Grade getGrade() { return grade; }
    public StudentStatus getStatus() { return status; }
}
