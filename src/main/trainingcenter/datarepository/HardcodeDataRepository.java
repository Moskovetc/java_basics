package main.trainingcenter.datarepository;

import main.trainingcenter.student.Course;
import main.trainingcenter.student.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardcodeDataRepository implements IDataRepository {

    private Student getStudent(String studentName, String curriculum,
                               LocalDateTime startDate, List<Course> courses, List<Integer> marks) {
        Student student = new Student();
        student.setName(studentName);
        student.setCurriculum(curriculum);
        student.setStartDate(startDate);
        student.setCourses(courses);
        student.setMarks(marks);
        return student;
    }

    @Override
    public List getData() {
        List<Student> students = new ArrayList<>();

        String studentName = "Ivanov Ivan";
        String curriculum = "J2EE Developer";
        LocalDateTime startDate = LocalDateTime.of(2018, 11, 10, 10, 00);
        List<Integer> marks = Arrays.asList(3, 4, 2, 5, 3, 3);
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Технология Java Servlets", 16));
        courses.add(new Course("Struts Framework", 24));
        courses.add(new Course("Spring Framework", 48));
        courses.add(new Course("Hibernate", 20));
        students.add(getStudent(studentName, curriculum, startDate, courses, marks));

        studentName = "Petrov Petr";
        curriculum = "Java Developer";
        startDate = LocalDateTime.of(2018, 11, 9, 10, 00);
        marks = Arrays.asList(4, 5, 3, 2, 5, 5, 5, 5);
        courses = new ArrayList<>();
        courses.add(new Course("Обзор технологий Java", 8));
        courses.add(new Course("Библиотека JFC/Swing", 16));
        courses.add(new Course("Технология JDBC", 16));
        courses.add(new Course("Технология JAX", 52));
        courses.add(new Course("Библиотеки commons", 44));
        students.add(getStudent(studentName, curriculum, startDate, courses, marks));

        studentName = "Kostin Kostya";
        curriculum = "Java Developer";
        startDate = LocalDateTime.of(2018, 11, 7, 10, 00);
        marks = Arrays.asList(4, 5, 3, 2, 2, 5, 3, 5);
        courses = new ArrayList<>();
        courses.add(new Course("Обзор технологий Java", 8));
        courses.add(new Course("Библиотека JFC/Swing", 16));
        courses.add(new Course("Технология JDBC", 16));
        courses.add(new Course("Технология JAX", 52));
        courses.add(new Course("Библиотеки commons", 44));
        courses.add(new Course("Collections Framework", 57));
        students.add(getStudent(studentName, curriculum, startDate, courses, marks));

        return students;
    }
}
