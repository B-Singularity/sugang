package com.sugang.course.adapter.out.persistence.repository;

import com.sugang.course.adapter.out.persistence.entity.OpenedCourseJpaEntity;
import com.sugang.course.application.port.in.LoadOpenedCourseQuery;
import java.util.List;

public interface OpenedCourseRepositoryCustom {
  List<OpenedCourseJpaEntity> search(LoadOpenedCourseQuery.OpendedCourseSearchCommand command);
}
