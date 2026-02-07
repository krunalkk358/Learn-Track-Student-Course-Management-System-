package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.List;

public interface StudentRepository {

    void save(Student student);

    void delete(Student student);

    Student findById(Long id) throws EntityNotFoundException;

    List<Student> findAll();
}
