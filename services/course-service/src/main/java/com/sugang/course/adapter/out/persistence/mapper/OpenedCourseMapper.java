package com.sugang.course.adapter.out.persistence.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sugang.course.adapter.out.persistence.entity.OpenedCourseJpaEntity;
import com.sugang.course.application.port.in.ManageOpenedCourseUseCase;
import com.sugang.course.domain.aggregate.OpenedCourse;
import com.sugang.course.domain.vo.Instructor;
import com.sugang.course.domain.vo.OpenedCourseId;
import java.util.Collections;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface OpenedCourseMapper {

  // 도메인 -> 엔티티 변환
  @Mapping(source = "openedCourseId", target = "id")
  OpenedCourseJpaEntity toEntity(OpenedCourse openedCourse);

  // 엔티티 -> 도메인 변환
  @Mapping(source = "id", target = "openedCourseId")
  OpenedCourse toDomain(OpenedCourseJpaEntity entity);

  @Mapping(target = "openedCourseId", source = "id")
  @Mapping(target = "courseCode", source = "command.courseCode")
  @Mapping(target = "semester", source = "command.semester")
  @Mapping(target = "instructors", source = "command.instructors")
  @Mapping(target = "classSchedule", source = "command.classSchedule")
  @Mapping(target = "quota", source = "command.quota")
  @Mapping(target = "syllabus", source = "command.syllabus")
  OpenedCourse toDomain(ManageOpenedCourseUseCase.CreateOpenedCourseCommand command, OpenedCourseId id);

  // --- 커스텀 매핑 메서드 (Set<Instructor> <-> String) ---
  @Named("instructorsToString")
  default String instructorsToString(Set<Instructor> instructors) {
    if (instructors == null || instructors.isEmpty()) {
      return null;
    }
    try {
      return new ObjectMapper().writeValueAsString(instructors);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Set<Instructor> -> JSON 변환 실패", e);
    }
  }

  @Named("stringToInstructors")
  default Set<Instructor> stringToInstructors(String json) {
    if (json == null || json.isBlank()) {
      return Collections.emptySet();
    }
    try {
      return new ObjectMapper().readValue(json, new TypeReference<>() {});
    } catch (JsonProcessingException e) {
      throw new RuntimeException("JSON -> Set<Instructor> 변환 실패", e);
    }
  }
}
