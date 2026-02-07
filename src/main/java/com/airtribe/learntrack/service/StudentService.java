package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.StudentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudent(Long id, String firstName, String lastName,
                           String batch, int yearOfJoining) {

        Student student = new Student(id, firstName, lastName, batch, yearOfJoining);
        students.add(student);
    }

    public Student searchStudentById(Long id) throws EntityNotFoundException {
        return findById(id);
    }

    public void activateStudent(Long id) throws EntityNotFoundException {
        Student student = findById(id);
        student.setStatus(StudentStatus.ACTIVE);
    }

    public void deactivateStudent(Long id) throws EntityNotFoundException {
        Student student = findById(id);
        student.setStatus(StudentStatus.INACTIVE);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            System.out.println(
                    s.getDisplayName() +
                            " | Batch: " + s.getBatch() +
                            " | Year: " + s.getYearOfJoining() +
                            " | Status: " + s.getStatus()
            );
        }
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public void delete(Student student) {
        students.remove(student);
    }

    @Override
    public Student findById(Long id) throws EntityNotFoundException {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        throw new EntityNotFoundException("Student not found with ID: " + id);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }
}
