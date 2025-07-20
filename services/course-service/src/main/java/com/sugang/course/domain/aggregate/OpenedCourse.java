package com.sugang.course.domain.aggregate;

import com.sugang.course.application.port.in.ManageOpenedCourseUseCase;
import com.sugang.course.domain.vo.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OpenedCourse {

  private OpenedCourseId openedCourseId;
  private CourseCode courseCode;
  private Semester semester;
  private Set<Instructor> instructors = new HashSet<>();
  private ClassSchedule classSchedule;
  private Quota quota;
  private Syllabus syllabus;

  @Builder
  public OpenedCourse(
      OpenedCourseId openedCourseId,
      CourseCode courseCode,
      Semester semester,
      Set<Instructor> instructors,
      ClassSchedule classSchedule,
      Quota quota,
      Syllabus syllabus) {
    Objects.requireNonNull(openedCourseId, "개설 강의 ID는 필수입니다.");
    Objects.requireNonNull(semester, "학기 정보는 필수입니다.");
    Objects.requireNonNull(classSchedule, "강의 시간은 필수입니다.");
    Objects.requireNonNull(quota, "정원 정보는 필수입니다.");
    Objects.requireNonNull(courseCode, "과목 코드는 필수입니다.");

    this.openedCourseId = openedCourseId;
    this.courseCode = courseCode;
    this.semester = semester;
    this.instructors = Objects.requireNonNullElse(instructors, new HashSet<>());
    this.classSchedule = classSchedule;
    this.quota = quota;
    this.syllabus = syllabus;
  }

  public void increaseEnrollment() {
    this.quota = this.quota.increaseRegisteredCount();
  }

  public void decreaseEnrollment() {
    this.quota = this.quota.decreaseRegisteredCount();
  }

  public void addInstructor(Instructor instructor) {
    this.instructors.add(instructor);
  }

  public void removeInstructor(Instructor instructor) {
    if (this.instructors.size() <= 1) {
      throw new IllegalStateException("강의에는 최소 1명 이상의 강사가 배정되어야 합니다.");
    }
    this.instructors.remove(instructor);
  }

  public Set<Instructor> getInstructors() {
    return Collections.unmodifiableSet(this.instructors);
  }

  public void updateDetails(ManageOpenedCourseUseCase.UpdateOpenedCourseCommand command) {
    if (command.capacity() < this.quota.getRegisteredCount()) {
      throw new IllegalArgumentException("총 정원을 현재 신청 인원보다 적게 설정할 수 없습니다.");
    }
    this.instructors = command.instructors();
    this.classSchedule = command.classSchedule();
    this.syllabus = command.syllabus();
    this.quota = new Quota(command.capacity(), this.quota.getRegisteredCount());
  }
}
