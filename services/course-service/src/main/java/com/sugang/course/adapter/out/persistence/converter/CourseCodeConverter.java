package com.sugang.course.adapter.out.persistence.converter;

import com.sugang.course.domain.vo.CourseCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CourseCodeConverter implements AttributeConverter<CourseCode, String> {

  @Override
  public String convertToDatabaseColumn(CourseCode attribute) {
    return attribute == null ? null : attribute.value();
  }

  @Override
  public CourseCode convertToEntityAttribute(String dbData) {
    return dbData == null ? null : new CourseCode(dbData);
  }
}
