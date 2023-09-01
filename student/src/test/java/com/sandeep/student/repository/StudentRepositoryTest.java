package com.sandeep.student.repository;

import com.sandeep.student.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentRepositoryTest(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    void findAllBySchoolIdTest() {
        Integer schoolId = 1;
        List<Student> studentList = studentRepository.findAllBySchoolId(schoolId);

        System.out.println(studentList);
    }
}
