package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseRepository {

    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void deactivateCourse(Long id) throws EntityNotFoundException {
        Course course = findById(id);
        course.setStatus(CourseStatus.INACTIVE);
    }

    @Override
    public void save(Course course) {
        courses.add(course);
    }

    @Override
    public Course findById(Long id) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        throw new EntityNotFoundException("Course not found with ID: " + id);
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }
}
