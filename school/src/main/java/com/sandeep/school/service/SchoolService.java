package com.sandeep.school.service;


import com.sandeep.school.model.School;
import com.sandeep.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository SchoolRepository;

    @Autowired
    public SchoolService(SchoolRepository SchoolRepository) {
        this.SchoolRepository = SchoolRepository;
    }

    public void saveSchool(School School) {
        SchoolRepository.save(School);
    }

    public List<School> findAllSchools() {
        return SchoolRepository.findAll();
    }
}
