package com.sugang.course.adapter.in.web;

import com.sugang.course.application.port.in.ManageCourseUseCase;
import com.sugang.course.domain.vo.OpenedCourseId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminCourseController {

    private final ManageCourseUseCase manageCourseUseCase;

    @PostMapping("/api/v1/admin/courses")
    public ResponseEntity<Void> createCourse(
            @RequestBody ManageCourseUseCase.CreateOpenedCourseCommand command
    ) {
        manageCourseUseCase.createOpenedCourse(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<Void> updateCourse(
            @PathVariable String id,
            @RequestBody ManageCourseUseCase.UpdateOpenedCourseCommand command
    ) {
        manageCourseUseCase.updateOpenedCourse(new OpenedCourseId(id), command);
        return ResponseEntity.ok().build();
    }



}
