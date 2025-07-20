package com.sugang.course.adapter.in.web;

import com.sugang.course.application.port.in.ManageOpenedCourseUseCase;
import com.sugang.course.domain.vo.OpenedCourseId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminCourseController {

    private final ManageOpenedCourseUseCase manageOpenedCourseUseCase;

    @PostMapping("/api/v1/admin/opened-courses")
    public ResponseEntity<Void> createOpenedCourse(
            @RequestBody ManageOpenedCourseUseCase.CreateOpenedCourseCommand command
    ) {
        manageOpenedCourseUseCase.createOpenedCourse(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/api/v1/admin/opened-courses/{openedCourseId}")
    public ResponseEntity<Void> updateCourse(
            @PathVariable String openedCourseId,
            @RequestBody ManageOpenedCourseUseCase.UpdateOpenedCourseCommand command
    ) {
        manageOpenedCourseUseCase.updateOpenedCourse(new OpenedCourseId(openedCourseId), command);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/v1/admin/opened-courses/{openedCourseId}")
    public ResponseEntity<Void> deleteOpenedCourse(@PathVariable String openedCourseId) {
        manageOpenedCourseUseCase.deleteOpenedCourse(new OpenedCourseId(openedCourseId));
        return ResponseEntity.noContent().build();
    }



}
