package week4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Course> courses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int courseCount;
        do {
            System.out.print("How many courses to create (at least 3): ");
            courseCount = Integer.parseInt(scanner.nextLine());
        } while (courseCount < 3);

        for (int i = 1; i <= courseCount; i++) {
            System.out.print("Course name: ");
            String courseName = scanner.nextLine();
            System.out.print("Course capacity: ");
            int capacity = Integer.parseInt(scanner.nextLine());
            Course newCourse = new Course(courseName, capacity);
            courses.add(newCourse);
        }

        System.out.println("\n*** AVAILABLE COURSES ***");
        for (Course course : courses) {
            System.out.println("- " + course.courseName);
        }

        boolean running = true;
        while (running) {
            System.out.println("\n1. Register student");
            System.out.println("2. View all courses");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Student ID: ");
                int studentID = Integer.parseInt(scanner.nextLine());
                System.out.print("Student name: ");
                String studentName = scanner.nextLine();
                System.out.print("Course name to register: ");
                String requestedCourseName = scanner.nextLine();

                Course selectedCourse = null;
                for (Course course : courses) {
                    if (course.courseName.equals(requestedCourseName)) {
                        selectedCourse = course;
                        break;
                    }
                }

                if (selectedCourse == null) {
                    System.out.println("No course found with that name.");
                } else if (selectedCourse.isFull()) {
                    System.out.println("This course is full. Registration failed.");
                } else if (selectedCourse.isRegistered(studentID)) {
                    System.out.println("This student is already registered for this course.");
                } else {
                    Student newStudent = new Student(studentID, studentName);
                    selectedCourse.enrolledStudents.add(newStudent);
                    System.out.println("Registration successful.");
                }
            } else if (choice.equals("2")) {
                System.out.println("\n*** COURSE INFORMATION ***");
                for (Course course : courses) {
                    course.display();
                }
            } else if (choice.equals("3")) {
                running = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
