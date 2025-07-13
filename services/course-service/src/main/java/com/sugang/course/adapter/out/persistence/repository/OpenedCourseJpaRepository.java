package com.sugang.course.adapter.out.persistence.repository;

import com.sugang.course.adapter.out.persistence.entity.OpenedCourseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenedCourseJpaRepository extends JpaRepository<OpenedCourseJpaEntity, String>, OpenedCourseRepositoryCustom {}
