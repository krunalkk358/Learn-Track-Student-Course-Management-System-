package com.airtribe.learntrack.entity;

public class Enrollment {

    private Long id;

    private Long studentId;

    private Long courseId;

    private String enrollementDate;

    private boolean status;

    // No-args Constructor
    public Enrollment(){

    }

    // Parameterized Controller
    public Enrollment(Long id, Long studentId, Long courseId, String enrollementDate, boolean status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollementDate = enrollementDate;
        this.status = status;
    }

    // Adding Getter Methods
    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getEnrollementDate() {
        return enrollementDate;
    }

    public boolean isStatus() {
        return status;
    }

    // Adding Setter Methods

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setEnrollementDate(String enrollementDate) {
        this.enrollementDate = enrollementDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
