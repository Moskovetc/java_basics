package main.trainingcenter;

import main.trainingcenter.datarepository.HardcodeDataRepository;
import main.trainingcenter.datarepository.IDataRepository;
import main.trainingcenter.student.Course;
import main.trainingcenter.student.Student;

import java.time.Duration;
import java.util.*;
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
                "4. temp\n" +
                "5. Exit");
        System.out.print("your choice : ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("2")) {
            filterStudentsByAverageMark(students);
        } else if (choice.equals("3")) {
            filterStudentsByEndOfEducation(students);
        } else if (choice.equals("4")) {
            temp(students);
        }
    }

    private void temp(List<Student> students) {
        System.out.println(students.get(0).getStartDate());
        System.out.println(students.get(1).getStartDate());
        System.out.println(Duration.between(students.get(0).getStartDate(), students.get(1).getStartDate()).toHours());
        System.out.println(getEndOfEducation(students.get(0)));

    }

    private int getEndOfEducation(Student student) {
        int durationOfCourses = Arrays.stream(student.getCourses().stream()
                .mapToInt(Course::getDuration).toArray())
                .reduce((s1, s2) -> s1 + s2).orElse(0);
        int hoursOfEducationPassed = student.getMarks().size() * 8;
        return durationOfCourses - hoursOfEducationPassed;

    }

    private boolean getAcademicPerfomance(Student student) {

        return false;
    }

    private void filterStudentsByAverageMark(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparing(this::getAverageMark))
                .peek(student -> System.out.println(String.format("%s %s", student.getName(), getAverageMark(student))))
                .collect(Collectors.toList());

    }

    private Double getAverageMark(Student student) {
        return student.getMarks().stream().collect(Collectors.averagingInt((mark) -> mark));
    }

    private void filterStudentsByEndOfEducation(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparing(this::getEndOfEducation))
                .peek(student -> System.out.println(String.format("%s %s", student.getName(), getEndOfEducation(student))))
                .collect(Collectors.toList());
    }

    private boolean filterStudentsByAcademicPerfomance(List<Student> students) {
        return false;
    }

    public void setStudentFile(String filePath) {
        this.filePath = filePath;
    }

}
