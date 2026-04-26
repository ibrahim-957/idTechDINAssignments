package com.ibrahim.sixthmonth.controller;

import com.ibrahim.sixthmonth.model.request.CreateStudentRequest;
import com.ibrahim.sixthmonth.model.request.DropCourseRequest;
import com.ibrahim.sixthmonth.model.request.TakeCourseRequest;
import com.ibrahim.sixthmonth.model.response.StudentResponse;
import com.ibrahim.sixthmonth.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody CreateStudentRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.createStudent(request));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentResponse>> getStudentsOlderThan20(){
        return ResponseEntity.ok(studentService.findStudentsOlderThan20());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping("/{studentId}/course/take")
    public ResponseEntity<StudentResponse> takeCourse(@PathVariable Long studentId, @RequestBody TakeCourseRequest request){
        return ResponseEntity.ok(studentService.takeCourse(studentId, request));
    }

    @PostMapping("/{studentId}/course/drop")
    public ResponseEntity<StudentResponse> dropCourse(@PathVariable Long studentId, @RequestBody DropCourseRequest request){
        return ResponseEntity.ok(studentService.dropCourse(studentId, request));
    }
}
