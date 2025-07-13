package com.sugang.course.adapter.out.persistence.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sugang.course.domain.vo.Instructor;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Collections;
import java.util.Set;

@Converter
public class InstructorsConverter implements AttributeConverter<Set<Instructor>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Set<Instructor> instructors) {
        if (instructors == null || instructors.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(instructors);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Set<Instructor> -> JSON 변환 실패", e);
        }
    }

    @Override
    public Set<Instructor> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return Collections.emptySet();
        }
        try {
            return objectMapper.readValue(dbData, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("JSON -> Set<Instructor> 변환 실패", e);
        }
    }
}
