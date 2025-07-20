package com.sugang.course.application.service;

import com.sugang.course.adapter.out.persistence.mapper.CourseMapper;
import com.sugang.course.application.port.in.LoadCourseCatalogQuery;
import com.sugang.course.application.port.in.ManageCourseUseCase;
import com.sugang.course.application.port.out.CourseRepositoryPort;
import com.sugang.course.domain.aggregate.Course;
import com.sugang.course.domain.vo.CourseCode;
import com.sugang.course.global.exception.CourseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseService implements ManageCourseUseCase, LoadCourseCatalogQuery {

    private final CourseRepositoryPort courseRepositoryPort;
    private final CourseMapper courseMapper;


    @Override
    public Course loadCourse(CourseCode courseCode) {
        return courseRepositoryPort.findByCourseCode(courseCode)
                .orElseThrow(() -> new CourseNotFoundException(courseCode));
    }

    @Override
    @Transactional
    public Course createCourse(ManageCourseUseCase.CreateCourseCommand command) {
        courseRepositoryPort.findByCourseCode(command.courseCode())
                .ifPresent(c -> {
                    throw new IllegalArgumentException("이미 존재하는 과목 코드입니다.");
                });

        return courseRepositoryPort.save(courseMapper.toDomain(command));
    }

    @Override
    @Transactional
    public Course updateCourse(ManageCourseUseCase.UpdateCourseCommand command) {
        CourseCode courseCode = command.courseCode();
        Course course = courseRepositoryPort.findByCourseCode(courseCode) // NOSONAR
                .orElseThrow(() -> new CourseNotFoundException(courseCode)); // NOSONAR

        courseMapper.updateCourseFromCommand(command, course);
        return courseRepositoryPort.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(CourseCode courseCode) {
        courseRepositoryPort.deleteByCourseCode(courseCode);
    }



}
