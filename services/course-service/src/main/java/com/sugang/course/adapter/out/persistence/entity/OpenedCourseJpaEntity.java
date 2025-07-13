package com.sugang.course.adapter.out.persistence.entity;

import com.sugang.course.adapter.out.persistence.converter.CourseCodeConverter;
import com.sugang.course.adapter.out.persistence.converter.InstructorsConverter;
import com.sugang.course.adapter.out.persistence.converter.OpenedCourseIdConverter;
import com.sugang.course.adapter.out.persistence.converter.SyllabusConverter;
import com.sugang.course.domain.vo.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Table(name = "opened_courses")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OpenedCourseJpaEntity {

  @Id
  @Convert(converter = OpenedCourseIdConverter.class)
  private OpenedCourseId id;

  @Convert(converter = CourseCodeConverter.class)
  private CourseCode courseCode;

  @Embedded
  private Semester semester;

  @Convert(converter = InstructorsConverter.class)
  private Set<Instructor> instructors;

  @Embedded
  private ClassSchedule classSchedule;

  @Embedded
  private Quota quota;

  @Convert(converter = SyllabusConverter.class)
  private Syllabus syllabus;


}
