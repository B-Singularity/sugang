package com.sugang.course.adapter.out.persistence.converter;

import com.sugang.course.domain.vo.Syllabus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SyllabusConverter implements AttributeConverter<Syllabus, String> {

  @Override
  public String convertToDatabaseColumn(Syllabus attribute) {
    return attribute == null ? null : attribute.content();
  }

  @Override
  public Syllabus convertToEntityAttribute(String dbData) {
    return dbData == null ? null : new Syllabus(dbData);
  }
}
