package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.List;

public interface CourseRepository {

    void save(Course course);

    Course findById(Long id) throws EntityNotFoundException;

    List<Course> findAll();
}
