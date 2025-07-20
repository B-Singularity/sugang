package com.sugang.course.adapter.out.persistence.mapper;

import com.sugang.course.adapter.out.persistence.entity.CourseJpaEntity;
import com.sugang.course.application.port.in.ManageCourseUseCase;
import com.sugang.course.domain.aggregate.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = CompletionRuleMapper.class)
public interface CourseMapper {

  @Mapping(target = "prerequisites", ignore = true)
  @Mapping(target = "completionRules", ignore = true)
  CourseJpaEntity toEntity(Course course);

  @Mapping(target = "prerequisites", ignore = true)
  @Mapping(target = "completionRules", ignore = true)
  Course toDomain(CourseJpaEntity entity);

  Course toDomain(ManageCourseUseCase.CreateCourseCommand command);

  void updateCourseFromCommand(ManageCourseUseCase.UpdateCourseCommand command, @MappingTarget Course course);
}


