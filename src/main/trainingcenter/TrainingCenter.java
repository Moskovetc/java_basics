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

    public void runMenu() {
        ShowManager showManager = new ShowManager();
        showManager.setAverageMarkForAcademicPerfomance(4.5);
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
        switch (choice) {
            case "1":
                showManager.showStudentsSortedByAcademicPerfomance(students);
                break;
            case "2":
                showManager.showStudentsSortedByAverageMark(students);
                break;
            case "3":
                showManager.showStudentsSortedByEndOfEducation(students);
                break;
            case "4":
                System.out.println("Bye!");
                break;
        }
    }

    public void setStudentFile(String filePath) {
        this.filePath = filePath;
    }

}
