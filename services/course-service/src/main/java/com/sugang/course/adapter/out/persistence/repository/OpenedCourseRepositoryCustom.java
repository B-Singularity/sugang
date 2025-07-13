package com.sugang.course.adapter.out.persistence.repository;

import com.sugang.course.adapter.out.persistence.entity.OpenedCourseJpaEntity;
import com.sugang.course.application.port.in.LoadCourseQuery;
import java.util.List;

public interface OpenedCourseRepositoryCustom {
  List<OpenedCourseJpaEntity> search(LoadCourseQuery.CourseSearchCommand command);
}
