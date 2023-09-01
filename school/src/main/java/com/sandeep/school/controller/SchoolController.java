package com.sandeep.school.controller;

import com.sandeep.school.model.School;
import com.sandeep.school.responses.FullSchoolResponse;
import com.sandeep.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody School school) {
        schoolService.saveSchool(school);
    }

    @GetMapping
    public List<School> getAllStudents() {
        return schoolService.findAllSchools();
    }

    @GetMapping("/school-with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> getAllSchoolsWithStudents(@PathVariable Integer schoolId) {
        FullSchoolResponse fullSchoolResponse = schoolService.findAllSchoolsWithStudents(schoolId);
        return ResponseEntity.ok().body(fullSchoolResponse);
    }
}
