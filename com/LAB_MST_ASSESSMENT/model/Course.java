package com.course.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private int maxSeats;
    private int enrolledStudents;
    private final List<Student> students;

    public Course() {
        this.students = new ArrayList<>();
    }

    public Course(int courseId, String courseName, int maxSeats) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.maxSeats = maxSeats;
        this.enrolledStudents = 0;
        this.students = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public boolean hasStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return true;
            }
        }
        return false;
    }

    public void addStudent(Student student) {
        students.add(student);
        enrolledStudents = students.size();
    }

    public void displayCourse() {
        System.out.println("Course ID: " + courseId + ", Name: " + courseName + ", Seats: " + enrolledStudents + "/" + maxSeats);
        if (students.isEmpty()) {
            System.out.println("  No enrolled students yet.");
        } else {
            System.out.println("  Enrolled Students:");
            for (Student student : students) {
                System.out.println("  - " + student.getStudentId() + " : " + student.getStudentName());
            }
        }
    }
}
