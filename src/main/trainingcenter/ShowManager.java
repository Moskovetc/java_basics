package main.trainingcenter;

import main.trainingcenter.student.Course;
import main.trainingcenter.student.Student;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShowManager {
    private double averageMarkForAcademicPerfomance;

    public void showStudentsSortedByAverageMark(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparing(this::getAverageMark))
                .forEach(student -> System.out.println(String.format("Student: %s average mark: %.1f",
                        student.getName(), getAverageMark(student))));


    }

    public void showStudentsSortedByEndOfEducation(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparing(this::getEndOfEducation))
                .forEach(student -> System.out.println(String.format("Student: %s end of education: %s days, %s hours",
                        student.getName(), getEndOfEducation(student) / 24, getEndOfEducation(student) % 24)));
    }

    public void showStudentsSortedByAcademicPerfomance(List<Student> students) {
        students.stream()
                .sorted((student1, student2) ->
                        -Boolean.compare(getAcademicPerfomance(student1), getAcademicPerfomance(student2)))
                .forEach(student -> System.out.println(
                        String.format("Student: %s average mark: %.1f " +
                                        "end of education: %s days, %s hours Continue Training: %s",
                                student.getName(), getAverageMark(student), getEndOfEducation(student) / 24,
                                getEndOfEducation(student) % 24, getAcademicPerfomance(student))
                ));

    }

    private long getEndOfEducation(Student student) {
        int durationOfCoursesHours = Arrays.stream(student.getCourses().stream()
                .mapToInt(Course::getDuration).toArray())
                .reduce((s1, s2) -> s1 + s2).orElse(0);
        int daysOfEducation = durationOfCoursesHours / 8;
        int hoursDiv = durationOfCoursesHours % 8;
        LocalDateTime endDate = student.getStartDate().plusDays(daysOfEducation).plusHours(hoursDiv);
        LocalDateTime currentDate = student.getStartDate().plusDays(student.getMarks().size());
        return ChronoUnit.HOURS.between(currentDate, endDate);

    }

    private boolean getAcademicPerfomance(Student student) {
        Stream<Integer> streamMarks = student.getMarks().stream();
        int posibleDays = (int) (getEndOfEducation(student) / 24);
        int countMark = student.getMarks().size() + posibleDays;
        float sumOfMark = (streamMarks.reduce((s1, s2) -> s1 + s2).orElse(0) + 5 * posibleDays);
        return averageMarkForAcademicPerfomance <= (sumOfMark / countMark);
    }

    private Double getAverageMark(Student student) {
        return student.getMarks().stream().collect(Collectors.averagingInt((mark) -> mark));
    }

    public void setAverageMarkForAcademicPerfomance(double averageMarkForAcademicPerfomance) {
        this.averageMarkForAcademicPerfomance = averageMarkForAcademicPerfomance;
    }
}
