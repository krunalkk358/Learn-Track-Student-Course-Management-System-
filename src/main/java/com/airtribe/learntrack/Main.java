package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        boolean exit = false;

        printHeader("LearnTrack – Student Course Management System");

        while (!exit) {
            try {
                printMainMenu();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        studentMenu(scanner, studentService);
                        break;
                    case 2:
                        courseMenu(scanner, courseService);
                        break;
                    case 3:
                        enrollmentMenu(scanner, enrollmentService);
                        break;
                    case 4:
                        exit = true;
                        printLine("Thank you for using LearnTrack. Goodbye!");
                        break;
                    default:
                        printError("Invalid option. Please choose again.");
                }
            } catch (Exception e) {
                printError("Invalid input. Please enter numbers only.");
                scanner.nextLine();
            }
        }
    }

    // ================= STUDENT MENU =================

    private static void studentMenu(Scanner scanner, StudentService service) {
        boolean back = false;

        while (!back) {
            printHeader("STUDENT MANAGEMENT");
            System.out.println(" ➤ 1. Add Student");
            System.out.println(" ➤ 2. View All Students");
            System.out.println(" ➤ 3. Search Student by ID");
            System.out.println(" ➤ 4. Activate Student");
            System.out.println(" ➤ 5. Deactivate Student");
            System.out.println(" ⬅  6. Back to Main Menu");
            printSeparator();

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Long id = IdGenerator.generateStudentId();
                        System.out.print("   First Name : ");
                        String fn = scanner.next();
                        System.out.print("   Last Name  : ");
                        String ln = scanner.next();
                        System.out.print("   Batch      : ");
                        String batch = scanner.next();
                        System.out.print("   Year       : ");
                        int year = scanner.nextInt();

                        service.addStudent(id, fn, ln, batch, year);
                        printSuccess("Student added successfully. ID: " + id);
                        break;

                    case 2:
                        service.displayAllStudents();
                        break;

                    case 3:
                        System.out.print("   Enter Student ID : ");
                        Student s = service.searchStudentById(scanner.nextLong());
                        printLine(s.getDisplayName() + " | Status: " + s.getStatus());
                        break;

                    case 4:
                        System.out.print("   Enter Student ID : ");
                        service.activateStudent(scanner.nextLong());
                        printSuccess("Student activated.");
                        break;

                    case 5:
                        System.out.print("   Enter Student ID : ");
                        service.deactivateStudent(scanner.nextLong());
                        printSuccess("Student deactivated.");
                        break;

                    case 6:
                        back = true;
                        break;

                    default:
                        printError("Invalid option.");
                }

            } catch (EntityNotFoundException e) {
                printError(e.getMessage());
            } catch (Exception e) {
                printError("Invalid input.");
                scanner.nextLine();
            }
        }
    }

    // ================= COURSE MENU =================

    private static void courseMenu(Scanner scanner, CourseService service) {
        boolean back = false;

        while (!back) {
            printHeader("COURSE MANAGEMENT");
            System.out.println(" ➤ 1. Add Course");
            System.out.println(" ➤ 2. View Courses");
            System.out.println(" ➤ 3. Deactivate Course");
            System.out.println(" ⬅  4. Back to Main Menu");
            printSeparator();

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Long id = IdGenerator.generateCourseId();
                        System.out.print("   Course Name : ");
                        String name = scanner.next();
                        System.out.print("   Description : ");
                        String desc = scanner.next();
                        System.out.print("   Duration    : ");
                        int dur = scanner.nextInt();

                        service.addCourse(new Course(id, name, desc, dur));
                        printSuccess("Course added. ID: " + id);
                        break;

                    case 2:
                        for (Course c : service.findAll()) {
                            printLine(c.getId() + " → " + c.getCourseName()
                                    + " | Status: " + c.getStatus());
                        }
                        break;

                    case 3:
                        System.out.print("   Enter Course ID : ");
                        service.deactivateCourse(scanner.nextLong());
                        printSuccess("Course deactivated.");
                        break;

                    case 4:
                        back = true;
                        break;

                    default:
                        printError("Invalid option.");
                }

            } catch (EntityNotFoundException e) {
                printError(e.getMessage());
            } catch (Exception e) {
                printError("Invalid input.");
                scanner.nextLine();
            }
        }
    }

    // ================= ENROLLMENT MENU =================

    private static void enrollmentMenu(Scanner scanner, EnrollmentService service) {
        boolean back = false;

        while (!back) {
            printHeader("ENROLLMENT MANAGEMENT");
            System.out.println(" ➤ 1. Enroll Student");
            System.out.println(" ➤ 2. View Enrollments by Student");
            System.out.println(" ➤ 3. Update Enrollment Status");
            System.out.println(" ⬅  4. Back to Main Menu");
            printSeparator();

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Long eid = IdGenerator.generateEnrollmentId();
                        System.out.print("   Student ID : ");
                        Long sid = scanner.nextLong();
                        System.out.print("   Course ID  : ");
                        Long cid = scanner.nextLong();

                        service.enrollStudent(new Enrollment(eid, sid, cid));
                        printSuccess("Enrollment successful. ID: " + eid);
                        break;

                    case 2:
                        System.out.print("   Student ID : ");
                        List<Enrollment> list =
                                service.getEnrollmentsByStudentId(scanner.nextLong());

                        for (Enrollment e : list) {
                            printLine("Enrollment ID: " + e.getId()
                                    + " | Status: " + e.getStatus());
                        }
                        break;

                    case 3:
                        System.out.print("   Enrollment ID : ");
                        Long enId = scanner.nextLong();
                        System.out.println("   → 1. COMPLETE");
                        System.out.println("   → 2. CANCEL");

                        int opt = scanner.nextInt();
                        EnrollmentStatus status =
                                (opt == 1) ? EnrollmentStatus.COMPLETED
                                        : EnrollmentStatus.CANCELLED;

                        service.updateEnrollmentStatus(enId, status);
                        printSuccess("Enrollment updated.");
                        break;

                    case 4:
                        back = true;
                        break;

                    default:
                        printError("Invalid option.");
                }

            } catch (EntityNotFoundException e) {
                printError(e.getMessage());
            } catch (Exception e) {
                printError("Invalid input.");
                scanner.nextLine();
            }
        }
    }

    // ================= UI HELPERS =================

    private static void printHeader(String title) {
        System.out.println(" ==============================================" + title + "==============================================");
    }

    private static void printSeparator() {
        System.out.println("----------------------------------------------");
        System.out.println("Enter Your Choice :  \n");
    }

    private static void printSuccess(String msg) {
        System.out.println(" ✔ " + msg);
    }

    private static void printError(String msg) {
        System.out.println(" ✖ " + msg);
    }

    private static void printLine(String msg) {
        System.out.println("   " + msg);
    }

    private static void printMainMenu() {
        printHeader("MAIN MENU");
        System.out.println(" ➤ 1. Student Management");
        System.out.println(" ➤ 2. Course Management");
        System.out.println(" ➤ 3. Enrollment Management");
        System.out.println(" ⬅ 4. Exit ");
        printSeparator();
    }
}
