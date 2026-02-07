package com.airtribe.learntrack.util;

public class IdGenerator {

    private static long studentId = 1000;
    private static long courseId = 2000;
    private static long enrollmentId = 3000;

    private IdGenerator() {
        // Prevent object creation
    }

    public static Long generateStudentId() {
        return ++studentId;
    }

    public static Long generateCourseId() {
        return ++courseId;
    }

    public static Long generateEnrollmentId() {
        return ++enrollmentId;
    }
}
