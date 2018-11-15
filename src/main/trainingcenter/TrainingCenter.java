package main.trainingcenter;

import main.trainingcenter.datarepository.HardcodeDataRepository;
import main.trainingcenter.datarepository.IDataRepository;
import main.trainingcenter.student.Course;
import main.trainingcenter.student.Student;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
                "1. list of students sorted by academic perfomance\n" +
                "2. list of students sorted by average mark\n" +
                "3. list of students sorted by education time\n" +
                "4. Exit\n");
        System.out.print("your choice : ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            filterStudentsByAcademicPerfomance(students);
        } else if (choice.equals("2")) {
            filterStudentsByAverageMark(students);
        } else if (choice.equals("3")) {
            filterStudentsByEndOfEducation(students);
        } else if (choice.equals("4")) {
            System.out.println("Bye!");
        }
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
        boolean continueTraining = false;
        Stream<Integer> streamMarks = student.getMarks().stream();
        int posibleDays = (int) (getEndOfEducation(student) / 24);
        int countMark = student.getMarks().size() + posibleDays;
        float sumOfMark = (streamMarks.reduce((s1, s2) -> s1 + s2).orElse(0) + 5 * posibleDays);
        if (4.5 <= (sumOfMark / countMark)) {
            continueTraining = true;
        }
        return continueTraining;
    }

    private void filterStudentsByAverageMark(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparing(this::getAverageMark))
                .peek(student -> System.out.println(String.format("Student: %s average mark: %s", student.getName(), getAverageMark(student))))
                .collect(Collectors.toList());

    }

    private Double getAverageMark(Student student) {
        return student.getMarks().stream().collect(Collectors.averagingInt((mark) -> mark));
    }

    private void filterStudentsByEndOfEducation(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparing(this::getEndOfEducation))
                .peek(student -> System.out.println(String.format("Student: %s end of education: %s days, %s hours", student.getName(), getEndOfEducation(student) / 24, getEndOfEducation(student) % 24)))
                .collect(Collectors.toList());
    }

    private void filterStudentsByAcademicPerfomance(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparing(this::getAcademicPerfomance))
                .peek(student -> System.out.println(String.format("Student: %s average mark: %s end of education: %s days, %s hours Continue Training: %s",
                        student.getName(), getAverageMark(student), getEndOfEducation(student) / 24, getEndOfEducation(student) % 24 , getAcademicPerfomance(student))))
                .collect(Collectors.toList());
    }

    public void setStudentFile(String filePath) {
        this.filePath = filePath;
    }

}
