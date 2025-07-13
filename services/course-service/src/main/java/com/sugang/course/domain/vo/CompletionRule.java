package com.sugang.course.domain.vo;

import com.sugang.course.adapter.out.persistence.converter.DepartmentIdConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Objects;
import lombok.*;

@Embeddable // <-- 이 어노테이션을 추가
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class CompletionRule {

  @Convert(converter = DepartmentIdConverter.class) // DepartmentId VO 변환
  private DepartmentId departmentId;

  @Enumerated(EnumType.STRING)
  private CourseType courseType;

  public CompletionRule(DepartmentId departmentId, CourseType courseType) {
    Objects.requireNonNull(departmentId, "학과 ID는 null일 수 없습니다.");
    Objects.requireNonNull(courseType, "이수 구분은 null일 수 없습니다.");
  }
}

