package main.trainingcenter;

import main.trainingcenter.student.Student;
import main.trainingcenter.datarepository.HardcodeDataRepository;
import main.trainingcenter.datarepository.IDataRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrainingCenter {
    private String filePath = "students.txt";
    private List students;

    public void run() {
        IDataRepository repository = new HardcodeDataRepository();
//        IDataRepository repository = new FileDataRepository(filePath);
        students = repository.getData();
        System.out.println("We glad to see you in the Training Center!\n" +
                "1. list of students\n" +
                "2. list of students sorted by average mark\n" +
                "3. Exit");
        System.out.print("your choice : ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("2")) {
            filterStudentsByAverageMark(students);
        }
    }

    private int calculateEndOfEducation(Student student) {

        return 0;
    }

    private float calculateAverageMark(Student student) {

        return 0;
    }

    private boolean calculateAcademicPerfomance(Student student) {

        return false;
    }

    private void filterStudentsByAverageMark(List<Student> students) {
        List<Student> sorted = students.stream()
                .sorted(Comparator.comparing(this::getAverage))
                .collect(Collectors.toList());
        sorted.forEach(item -> System.out.println(String.format("%s %s %s ",item.getName(), item.getMarks(), item.getStartDate())));
    }

    private Double getAverage(Student student){
        return student.getMarks().stream().collect(Collectors.averagingInt((mark) -> mark));
    }

    private boolean filterStudentsByEndOfEducation(List students) {
        return false;
    }

    private boolean filterStudentsByAcademicPerfomance(List students) {
        return false;
    }

    public void setStudentFile(String filePath) {
        this.filePath = filePath;
    }

}
