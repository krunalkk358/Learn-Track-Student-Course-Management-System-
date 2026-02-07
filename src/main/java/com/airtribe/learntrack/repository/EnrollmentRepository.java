package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.List;

public interface EnrollmentRepository {

    void save(Enrollment enrollment);

    Enrollment findById(Long id) throws EntityNotFoundException;

    List<Enrollment> findAll();
}
