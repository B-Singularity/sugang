package com.sugang.course.adapter.out.persistence.entity;

import com.sugang.course.domain.vo.CourseType;
import jakarta.persistence.*;

@Entity
@Table(name = "course_completion_rules")
public class CompletionRuleJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_code")
    private CourseJpaEntity course;

    private String departmentId;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;
}