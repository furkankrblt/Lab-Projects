package week4;

import java.util.ArrayList;

public class Course {
    String courseName;
    int capacity;
    ArrayList<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    public boolean isRegistered(int studentID) {
        for (Student student : enrolledStudents) {
            if (student.studentID == studentID) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled Students: " + enrolledStudents.size());
        if (enrolledStudents.isEmpty()) {
            System.out.println("Student Names: none");
        } else {
            System.out.println("Student Names:");
            for (Student student : enrolledStudents) {
                System.out.println("  - " + student.name);
            }
        }
        System.out.println("---------------------------");
    }
}
