package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.StudentStatus;

public class Student extends Person {

    private String batch;
    private StudentStatus status;
    private int yearOfJoining;

    public Student() {
        super();
    }

    // Full constructor
    public Student(Long id, String firstName, String lastName, String email,
                   String batch, int yearOfJoining, StudentStatus status) {

        super(id, firstName, lastName, email);
        this.batch = batch;
        this.yearOfJoining = yearOfJoining;
        this.status = status;
    }

    // Overloaded constructor (without email)
    public Student(Long id, String firstName, String lastName,
                   String batch, int yearOfJoining) {

        super(id, firstName, lastName, "NA");
        this.batch = batch;
        this.yearOfJoining = yearOfJoining;
        this.status = StudentStatus.ACTIVE;
    }

    @Override
    public String getDisplayName() {
        return "Student -> " + super.getDisplayName();
    }

    public String getBatch() {
        return batch;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
}
