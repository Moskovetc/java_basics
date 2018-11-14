package main.trainingcenter.student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Student {
    private String name;
    private String curriculum;
    private LocalDateTime startDate;
    private Collection<Course> courses;
    private Collection<Integer> marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Collection<Integer> getMarks() {
        return marks;
    }

    public void setMarks(Collection<Integer> marks) {
        this.marks = marks;
    }
}
