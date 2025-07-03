package com.sugang.course.domain.aggregate;

import com.sugang.course.domain.vo.CompletionRule;
import com.sugang.course.domain.vo.CourseCode;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

    private CourseCode courseCode;
    private String title;
    private String description;
    private Set<CourseCode> prerequisites = new HashSet<>();
    private Set<CompletionRule> completionRules = new HashSet<>();

    @Builder
    public Course(CourseCode courseCode,
                  String title,
                  String description,
                  Set<CourseCode> prerequisites,
                  Set<CompletionRule> completionRules) {
        Objects.requireNonNull(courseCode, "과목 코드는 필수입니다.");
        Objects.requireNonNull(title, "과목명은 필수입니다.");

        this.courseCode = courseCode;
        this.title = title;
        this.description = description;

        this.prerequisites = Objects.requireNonNullElse(prerequisites, new HashSet<>());
        this.completionRules = Objects.requireNonNullElse(completionRules, new HashSet<>());
    }

    public void addPrerequisite(CourseCode prerequisiteCode) {
        if (this.courseCode.equals(prerequisiteCode)) {
            throw new IllegalArgumentException("자기 자신을 선수과목으로 지정할 수 없습니다.");
        }
        this.prerequisites.add(prerequisiteCode);
    }

    public void removePrerequisite(CourseCode prerequisiteCode) {
        this.prerequisites.remove(prerequisiteCode);
    }

    public void addCompletionRule(CompletionRule rule) {
        this.completionRules.add(rule);
    }

    public void removeCompletionRule(CompletionRule rule) {
        this.completionRules.remove(rule);
    }

    public Set<CourseCode> getPrerequisites() {
        return Collections.unmodifiableSet(this.prerequisites);
    }

    public Set<CompletionRule> getCompletionRules() {
        return Collections.unmodifiableSet(this.completionRules);
    }
}
