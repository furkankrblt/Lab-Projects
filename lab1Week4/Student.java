package week4;

public class Student {
    int studentID;
    String name;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void print() {
        System.out.println("Student ID: " + studentID + "\nStudent Name: " + name);
    }
}
