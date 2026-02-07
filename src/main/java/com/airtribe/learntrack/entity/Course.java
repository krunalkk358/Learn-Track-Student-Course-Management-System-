package com.airtribe.learntrack.entity;

public class Course {

    private Long id;

    private String courseName;

    private String description;

    private Float durationInWeek;

    private boolean status;

    public Course() {
    }

    // Parameterized Controller
    public Course(Long id, String courseName, String description, Float durationInWeek, boolean status) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeek = durationInWeek;
        this.status = status;
    }

    // Adding Getter Method
    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public Float getDurationInWeek() {
        return durationInWeek;
    }

    public boolean isStatus() {
        return status;
    }

    // Adding Setter Method
    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDurationInWeek(Float durationInWeek) {
        this.durationInWeek = durationInWeek;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
