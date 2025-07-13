package com.sugang.course.adapter.out.persistence.mapper;

import com.sugang.course.adapter.out.persistence.entity.CompletionRuleJpaEntity;
import com.sugang.course.domain.vo.CompletionRule;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface CompletionRuleMapper {

    CompletionRuleMapper INSTANCE = Mappers.getMapper(CompletionRuleMapper.class);

    @Mapping(target = "course", ignore = true)
    CompletionRuleJpaEntity toEntity(CompletionRule domain);

    CompletionRule toDomain(CompletionRuleJpaEntity entity);
}
