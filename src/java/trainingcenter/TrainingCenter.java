package java.trainingcenter;

import java.trainingcenter.parser.DataParser;
import java.trainingcenter.student.Student;
import java.util.List;

public class TrainingCenter {
    private List students;

    public void run() {
        DataParser dataParser = new DataParser();
        students = dataParser.getStudents();
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

    private filterStudentsByAverageMark(List students) {

    }

    private filterStudentsByEndOfEducation(List students) {

    }

    private filterStudentsByAcademicPerfomance(List students) {

    }
}
