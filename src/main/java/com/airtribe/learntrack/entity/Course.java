package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseStatus;

public class Course {

    private Long id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private CourseStatus status;

    public Course(Long id, String courseName, String description, int durationInWeeks) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.status = CourseStatus.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }
}
