package com.sugang.course.adapter.out.persistence.entity;

import com.sugang.course.adapter.out.persistence.converter.CourseCodeConverter;
import com.sugang.course.domain.vo.CompletionRule;
import com.sugang.course.domain.vo.CourseCode;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CourseJpaEntity {

  @Id
  @Convert(converter = CourseCodeConverter.class)
  private CourseCode courseCode;

  private String title;
  private String description;


  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "course_prerequisites", joinColumns = @JoinColumn(name = "course_code"))
  @Column(name = "prerequisite_code")
  @Convert(converter = CourseCodeConverter.class) // 컬렉션의 각 원소에도 컨버터 적용
  @Builder.Default
  private Set<CourseCode> prerequisites = new HashSet<>();

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "course_completion_rules", joinColumns = @JoinColumn(name = "course_code"))
  @Builder.Default
  private Set<CompletionRule> completionRules = new HashSet<>();

  // 상태 변경을 위한 전용 메서드 (Setter 대용)
  public void changePrerequisites(Set<CourseCode> newPrerequisites) {
    if (this.prerequisites == null) {
      this.prerequisites = new HashSet<>();
    }
    this.prerequisites.clear();
    if (newPrerequisites != null) {
      this.prerequisites.addAll(newPrerequisites);
    }
  }
}
