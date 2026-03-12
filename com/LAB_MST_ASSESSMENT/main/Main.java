package com.course.main;

import com.course.exception.CourseFullException;
import com.course.exception.CourseNotFoundException;
import com.course.exception.DuplicateEnrollmentException;
import com.course.model.Course;
import com.course.model.Student;
import com.course.service.CourseService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOnline Course Enrollment System");
            System.out.println("1. Add Course");
            System.out.println("2. Enroll Student");
            System.out.println("3. View Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addCourse(scanner, courseService);
                    break;
                case 2:
                    enrollStudent(scanner, courseService);
                    break;
                case 3:
                    courseService.viewCourses();
                    break;
                case 4:
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static void addCourse(Scanner scanner, CourseService courseService) {
        try {
            System.out.print("Enter course ID: ");
            int courseId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine().trim();

            System.out.print("Enter max seats: ");
            int maxSeats = Integer.parseInt(scanner.nextLine().trim());

            if (maxSeats <= 0) {
                System.out.println("Max seats must be greater than 0.");
                return;
            }

            courseService.addCourse(new Course(courseId, courseName, maxSeats));
            System.out.println("Course added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Course not added.");
        } catch (Exception e) {
            System.out.println("Error while adding course: " + e.getMessage());
        }
    }

    private static void enrollStudent(Scanner scanner, CourseService courseService) {
        try {
            System.out.print("Enter course ID: ");
            int courseId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine().trim();

            courseService.enrollStudent(courseId, new Student(studentId, studentName));
            System.out.println("Student enrolled successfully.");
        } catch (CourseNotFoundException | CourseFullException | DuplicateEnrollmentException e) {
            System.out.println("Enrollment failed: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Enrollment failed.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
