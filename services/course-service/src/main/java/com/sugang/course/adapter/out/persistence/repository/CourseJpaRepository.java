package com.sugang.course.adapter.out.persistence.repository;

import com.sugang.course.adapter.out.persistence.entity.CourseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<CourseJpaEntity, String> {}
