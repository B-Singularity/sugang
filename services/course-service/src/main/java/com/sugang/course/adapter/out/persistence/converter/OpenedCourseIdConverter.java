package com.sugang.course.adapter.out.persistence.converter;

import com.sugang.course.domain.vo.OpenedCourseId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OpenedCourseIdConverter implements AttributeConverter<OpenedCourseId, String> {

  @Override
  public String convertToDatabaseColumn(OpenedCourseId attribute) {
    return attribute == null ? null : attribute.courseId();
  }

  @Override
  public OpenedCourseId convertToEntityAttribute(String dbData) {
    return dbData == null ? null : new OpenedCourseId(dbData);
  }
}
