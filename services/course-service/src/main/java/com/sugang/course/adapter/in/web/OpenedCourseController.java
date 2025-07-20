package com.sugang.course.adapter.in.web;

import com.sugang.course.adapter.in.web.dto.OpenedCourseDetailResponse;
import com.sugang.course.adapter.out.persistence.mapper.CourseDtoMapper;
import com.sugang.course.adapter.out.persistence.mapper.OpenedCourseDtoMapper;
import com.sugang.course.application.port.in.LoadCourseCatalogQuery;
import com.sugang.course.application.port.in.LoadOpenedCourseQuery;
import com.sugang.course.domain.aggregate.Course;
import com.sugang.course.domain.aggregate.OpenedCourse;
import com.sugang.course.domain.vo.OpenedCourseId;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OpenedCourseController {

    private final LoadCourseCatalogQuery loadCourseCatalogQuery;
    private final CourseDtoMapper courseDtoMapper;
    private final LoadOpenedCourseQuery loadOpenedCourseQuery;
    private final OpenedCourseDtoMapper openedCourseDtoMapper;


    @GetMapping("/api/v1/opened-courses/{id}")
    public ResponseEntity<OpenedCourseDetailResponse> getOpenedCourseDetail(@PathVariable String id) {
        OpenedCourse openedCourse = loadOpenedCourseQuery.loadOpendedCourse(new OpenedCourseId(id));
        Course course = loadCourseCatalogQuery.loadCourse(openedCourse.getCourseCode());
        OpenedCourseDetailResponse openedCourseDetailResponse = openedCourseDtoMapper.toResponse(openedCourse, course);

        return ResponseEntity.ok(openedCourseDetailResponse);
    }

    @GetMapping("/api/v1/opened-courses")
    public ResponseEntity<List<OpenedCourseDetailResponse>> searchOpenedCourses(
            LoadOpenedCourseQuery.OpendedCourseSearchCommand command
    ) {
        return ResponseEntity.ok(
                loadOpenedCourseQuery.searchOpenedCourse(command).stream()
                        .map(openedCourse -> {
                            Course course = loadCourseCatalogQuery.loadCourse(openedCourse.getCourseCode());
                            return openedCourseDtoMapper.toResponse(openedCourse, course);
                        })
                        .toList() // .collect(Collectors.toList()) -> .toList()
        );
    }


}
