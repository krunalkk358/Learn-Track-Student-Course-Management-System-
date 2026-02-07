package com.airtribe.learntrack.entity;

public class Trainer extends Person {

    private String specialization;
    private int experienceInYears;

    public Trainer(Long id, String firstName, String lastName, String email,
                   String specialization, int experienceInYears) {

        super(id, firstName, lastName, email);
        this.specialization = specialization;
        this.experienceInYears = experienceInYears;
    }

    @Override
    public String getDisplayName() {
        return "Trainer -> " + super.getDisplayName();
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }
}
