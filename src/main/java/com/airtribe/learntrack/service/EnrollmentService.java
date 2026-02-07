package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService implements EnrollmentRepository {

    private final List<Enrollment> enrollments = new ArrayList<>();

    public void enrollStudent(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId().equals(studentId)) {
                result.add(e);
            }
        }
        return result;
    }

    public void updateEnrollmentStatus(Long enrollmentId, EnrollmentStatus status)
            throws EntityNotFoundException {

        Enrollment enrollment = findById(enrollmentId);
        enrollment.setStatus(status);
    }

    @Override
    public void save(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    @Override
    public Enrollment findById(Long id) throws EntityNotFoundException {
        for (Enrollment e : enrollments) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        throw new EntityNotFoundException("Enrollment not found with ID: " + id);
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollments;
    }
}
