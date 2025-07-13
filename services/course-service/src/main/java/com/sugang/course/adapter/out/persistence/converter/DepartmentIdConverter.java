package com.sugang.course.adapter.out.persistence.converter;

import com.sugang.course.domain.vo.DepartmentId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DepartmentIdConverter implements AttributeConverter<DepartmentId, String> {

    @Override
    public String convertToDatabaseColumn(DepartmentId attribute) {
        return attribute == null ? null : attribute.id();
    }

    @Override
    public DepartmentId convertToEntityAttribute(String dbData) {
    return dbData == null ? null : new DepartmentId(dbData);
    }

}
