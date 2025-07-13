package com.sugang.course.adapter.out.persistence.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sugang.course.adapter.out.persistence.entity.OpenedCourseJpaEntity;
import com.sugang.course.application.port.in.LoadCourseQuery.CourseSearchCommand;
import com.sugang.course.domain.vo.CourseType;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.sugang.course.adapter.out.persistence.entity.QCourseJpaEntity.courseJpaEntity;
import static com.sugang.course.adapter.out.persistence.entity.QOpenedCourseJpaEntity.openedCourseJpaEntity;

@RequiredArgsConstructor
public class OpenedCourseRepositoryCustomImpl implements OpenedCourseRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<OpenedCourseJpaEntity> search(CourseSearchCommand command) {
        return queryFactory
                .selectFrom(openedCourseJpaEntity)
                .join(courseJpaEntity).on(openedCourseJpaEntity.courseCode.eq(courseJpaEntity.courseCode))
                .where(
                        departmentIdEq(command.departmentId()),
                        courseTypeEq(command.courseType()),
                        titleOrCodeContains(command.query())
                )
                .fetch();
    }

    private BooleanExpression departmentIdEq(String departmentId) {
        if (!StringUtils.hasText(departmentId)) {
            return null;
        }
        StringPath courseCodeValuePath = Expressions.stringPath(openedCourseJpaEntity.courseCode, "value");
        return courseCodeValuePath.like(departmentId + "%");
    }

    private BooleanExpression courseTypeEq(String courseType) {
        if (!StringUtils.hasText(courseType)) {
            return null;
        }
        return courseJpaEntity.completionRules.any().courseType.eq(CourseType.valueOf(courseType));
    }

    private BooleanExpression titleOrCodeContains(String query) {
        if (!StringUtils.hasText(query)) {
            return null;
        }
        StringPath courseCodeValuePath = Expressions.stringPath(openedCourseJpaEntity.courseCode, "value");
        return courseJpaEntity.title.containsIgnoreCase(query)
                .or(courseCodeValuePath.containsIgnoreCase(query));
    }
}