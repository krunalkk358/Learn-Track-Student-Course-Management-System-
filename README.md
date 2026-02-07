# LearnTrack – Student & Course Management System

LearnTrack is a Core Java, menu-driven console application designed to manage
students, courses, and enrollments using in-memory data structures.
The project demonstrates object-oriented programming principles,
clean code practices, and basic exception handling.

---

## 🚀 Features

### Student Management
- Add new students
- View all students with current status
- Search student by ID
- Activate / Deactivate students (soft delete)

### Course Management
- Add new courses
- View all courses
- Activate / Deactivate courses

### Enrollment Management
- Enroll a student into a course
- View enrollments for a student
- Mark enrollment as COMPLETED or CANCELLED

---

## 🛠 Tech Stack

- Java (Core Java, Java 17+ compatible)
- Console-based UI
- In-memory storage using ArrayList
- No database, no frameworks

---

## ▶️ How to Compile and Run

### Prerequisites
- JDK 17 or above
- IntelliJ IDEA / Eclipse / VS Code

### Steps
1. Clone the repository: (https://github.com/krunalkk358/Learn-Track-Student-Course-Management-System-)
2. Open the project in IntelliJ
3. Navigate to: src/main/java/com/airtribe/learntrack/Main.java
4. Run `Main.java`

  com.airtribe.learntrack
├── entity
├── service
├── repository
├── enums
├── util
├── exception
└── Main.java

# Design Notes – LearnTrack

## Why ArrayList instead of Array?
- ArrayList provides dynamic resizing.
- It allows easy addition and removal of elements.
- Suitable for in-memory storage where size is not fixed.
- Simplifies iteration and management compared to arrays.

## Where static members are used and why?
- `IdGenerator` uses static counters and methods.
- Static ensures unique ID generation across the application.
- Avoids the need to create objects just for ID generation.

## Where inheritance is used and benefits
- `Student` and `Trainer` extend the base class `Person`.
- Common attributes (id, name, email) are reused.
- Polymorphism is achieved using `getDisplayName()` method.
- Improves code reusability and maintainability.

## Clean Code Practices Followed
- Methods are short and focused on a single responsibility.
- Meaningful method names like `addStudent`, `findById`.
- Business logic is kept inside service classes.
- UI logic is isolated inside `Main.java`.
- Custom exceptions are used for clarity and safety.

  
