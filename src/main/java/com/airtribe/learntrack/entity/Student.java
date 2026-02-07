package com.airtribe.learntrack.entity;

public class Student extends Person {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String batch;

    private boolean status;

    public Student(){

    }


    // Parameterized Constructor
    public Student(Long id, String firstName, String lastName, String email, String batch, boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.batch = batch;
        this.status = status;
    }

    // Contructor with minimum field ( without email )
    public Student(Long id, String firstName, String lastName, String batch, boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.batch = batch;
        this.status = status;
    }

    @Override
    public String getDisplayName(){
        return "Student : " + super.getDisplayName();
    }

    // Adding Getter Methods

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBatch() {
        return batch;
    }

    public boolean isStatus() {
        return status;
    }

    // Adding Setter Methods


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
