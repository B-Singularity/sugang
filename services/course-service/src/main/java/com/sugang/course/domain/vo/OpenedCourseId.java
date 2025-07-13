package com.sugang.course.domain.vo;

import de.huxhorn.sulky.ulid.ULID;
import java.io.Serializable;
import java.util.Objects;

public record OpenedCourseId(String courseId) implements Serializable {

  public OpenedCourseId {
    Objects.requireNonNull(courseId, "개설 강의 ID는 null일 수 없습니다.");
  }

  public static OpenedCourseId generateCourseId() {
    return new OpenedCourseId(new ULID().nextULID());
  }
}
