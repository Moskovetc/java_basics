package main.trainingcenter;

import main.trainingcenter.datarepository.HardcodeDataRepository;
import main.trainingcenter.datarepository.IDataRepository;
import main.trainingcenter.student.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                "3. list of students sorted by education time\n" +
                "4. Exit");
        System.out.print("your choice : ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("2")) {
            filterStudentsByAverageMark(students);
        } else if (choice.equals("3")) {
            filterStudentsByEndOfEducation(students);
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
        students.stream()
                .sorted(Comparator.comparing(this::getAverage))
                .peek(student -> System.out.println(String.format("%s %s", student.getName(), getAverage(student))))
                .collect(Collectors.toList());

    }

    private Double getAverage(Student student) {
        return student.getMarks().stream().collect(Collectors.averagingInt((mark) -> mark));
    }

    private void filterStudentsByEndOfEducation(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparing(Student::getStartDate))
                .peek(student -> System.out.println(String.format("%s %s", student.getName(), student.getStartDate())))
                .collect(Collectors.toList());
    }

    private boolean filterStudentsByAcademicPerfomance(List<Student> students) {
        return false;
    }

    public void setStudentFile(String filePath) {
        this.filePath = filePath;
    }

}
