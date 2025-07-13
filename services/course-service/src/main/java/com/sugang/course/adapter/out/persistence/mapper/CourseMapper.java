package com.sugang.course.adapter.out.persistence.mapper;

import com.sugang.course.adapter.out.persistence.entity.CourseJpaEntity;
import com.sugang.course.domain.aggregate.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CompletionRuleMapper.class)
public interface CourseMapper {

  @Mapping(target = "prerequisites", ignore = true) // 매퍼가 직접 변환하지 않도록 무시
  @Mapping(target = "completionRules", ignore = true) // 매퍼가 직접 변환하지 않도록 무시
  CourseJpaEntity toEntity(Course course);

  @Mapping(target = "prerequisites", ignore = true)
  @Mapping(target = "completionRules", ignore = true)
  Course toDomain(CourseJpaEntity entity);
}


