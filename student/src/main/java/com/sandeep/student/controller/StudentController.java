package com.sandeep.student.controller;

import com.sandeep.student.model.Student;
import com.sandeep.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudents(@PathVariable("school-id") Integer schoolId) {
        List<Student> studentList = studentService.findAllStudentsBySchoolId(schoolId);
        return ResponseEntity.ok().body(studentList);
    }
}
