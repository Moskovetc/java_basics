package java.trainingcenter.student;

import java.util.Date;
import java.util.List;

public class Student {
    private String name;
    private String curriculum;
    private Date startDate;
    private List courses;
    private List marks;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List getCourses() {
        return courses;
    }

    public void setCourses(List courses) {
        this.courses = courses;
    }

    public List getMarks() {
        return marks;
    }

    public void setMarks(List marks) {
        this.marks = marks;
    }
}
