package main.trainingcenter.datarepository;

import main.trainingcenter.student.Course;
import main.trainingcenter.student.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardcodeDataRepository implements IDataRepository {
    @Override
    public List getData() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        Course course = new Course();
        List<Course> courses = new ArrayList<>();
        student.setName("Ivanov Ivan");
        student.setCurriculum("J2EE Developer");
        student.setStartDate(LocalDateTime.of(2018, 11, 10, 10, 00));
        course.setName("Технология Java Servlets");
        course.setDuration(16);
        courses.add(course);
        course.setName("Struts Framework");
        course.setDuration(24);
        courses.add(course);
        course.setName("Spring Framework");
        course.setDuration(48);
        courses.add(course);
        course.setName("Hibernate");
        course.setDuration(20);
        courses.add(course);
        student.setCourses(courses);
        student.setMarks(Arrays.asList(3, 4, 2, 5, 3, 3));
        students.add(student);

        student = new Student();
        student.setName("Petrov Petr");
        student.setCurriculum("Java Developer");
        student.setStartDate(LocalDateTime.of(2018, 11, 9, 10, 00));
        course.setName("Обзор технологий Java");
        course.setDuration(8);
        courses.add(course);
        course.setName("Библиотека JFC/Swing");
        course.setDuration(16);
        courses.add(course);
        course.setName("Технология JDBC");
        course.setDuration(16);
        courses.add(course);
        course.setName("Технология JAX");
        course.setDuration(52);
        courses.add(course);
        course.setName("Библиотеки commons");
        course.setDuration(44);
        courses.add(course);
        student.setCourses(courses);
        student.setMarks(Arrays.asList(4, 5, 3, 2, 3, 3, 5, 5));
        students.add(student);

        return students;
    }
}
