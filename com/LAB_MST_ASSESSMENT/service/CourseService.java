package com.course.service;

import com.course.exception.CourseFullException;
import com.course.exception.CourseNotFoundException;
import com.course.exception.DuplicateEnrollmentException;
import com.course.model.Course;
import com.course.model.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CourseService {
    private final Map<Integer, Course> courses;
    private final String filePath;

    public CourseService() {
        this("courses.txt");
    }

    public CourseService(String filePath) {
        this.filePath = filePath;
        this.courses = new LinkedHashMap<>();
        loadFromFile();
    }

    public void addCourse(Course c) {
        if (c == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        courses.put(c.getCourseId(), c);
        persistToFile();
    }

    public void enrollStudent(int courseId, Student s)
            throws CourseNotFoundException, CourseFullException, DuplicateEnrollmentException {
        Course course = courses.get(courseId);

        if (course == null) {
            throw new CourseNotFoundException("Course with ID " + courseId + " not found.");
        }

        if (course.hasStudent(s.getStudentId())) {
            throw new DuplicateEnrollmentException(
                    "Student with ID " + s.getStudentId() + " is already enrolled in course " + courseId + ".");
        }

        if (course.getEnrolledStudents() >= course.getMaxSeats()) {
            throw new CourseFullException("Course " + course.getCourseName() + " is full.");
        }

        course.addStudent(s);
        persistToFile();
    }

    public void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course course : courses.values()) {
            course.displayCourse();
        }
    }

    public Collection<Course> getAllCourses() {
        return courses.values();
    }

    private void persistToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Course course : courses.values()) {
                writer.write("COURSE|" + course.getCourseId() + "|" + course.getCourseName() + "|"
                        + course.getMaxSeats() + "|" + course.getEnrolledStudents());
                writer.newLine();

                for (Student student : course.getStudents()) {
                    writer.write("STUDENT|" + course.getCourseId() + "|" + student.getStudentId() + "|"
                            + student.getStudentName());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write enrollment data to file.", e);
        }
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", -1);

                if (parts.length == 0) {
                    continue;
                }

                if ("COURSE".equals(parts[0]) && parts.length >= 5) {
                    int courseId = Integer.parseInt(parts[1]);
                    String courseName = parts[2];
                    int maxSeats = Integer.parseInt(parts[3]);

                    Course course = new Course(courseId, courseName, maxSeats);
                    courses.put(courseId, course);
                } else if ("STUDENT".equals(parts[0]) && parts.length >= 4) {
                    int courseId = Integer.parseInt(parts[1]);
                    int studentId = Integer.parseInt(parts[2]);
                    String studentName = parts[3];

                    Course course = courses.get(courseId);
                    if (course != null && !course.hasStudent(studentId)
                            && course.getEnrolledStudents() < course.getMaxSeats()) {
                        course.addStudent(new Student(studentId, studentName));
                    }
                }
            }
        } catch (IOException e) {
            // File may not exist on first run, which is expected.
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid data format in enrollment file.", e);
        }
    }
}
