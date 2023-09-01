package com.sandeep.school.service;


import com.sandeep.school.clients.StudentClient;
import com.sandeep.school.model.School;
import com.sandeep.school.repository.SchoolRepository;
import com.sandeep.school.responses.FullSchoolResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    private final StudentClient studentClient;

    @Autowired
    public SchoolService(SchoolRepository SchoolRepository, StudentClient studentClient) {
        this.schoolRepository = SchoolRepository;
        this.studentClient = studentClient;
    }

    public void saveSchool(School School) {
        schoolRepository.save(School);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }


    public FullSchoolResponse findAllSchoolsWithStudents(Integer schoolId) {
        School school = schoolRepository.findById(schoolId).orElse(
                School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build()
        );

        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .id(school.getId())
                .name(school.getName())
                .email(school.getEmail())
                .studentList(students)
                .build();
    }
}
