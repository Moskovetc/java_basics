package main.trainingcenter.datarepository;

import main.trainingcenter.student.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileDataRepository implements IDataRepository {
    private final String filePath;

    public FileDataRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List getData() {
        try {
            Stream<String> streamFromFiles = Files.lines(Paths.get(filePath));
            Student student = new Student();
            student.setName(streamFromFiles.findFirst().toString());
            student.setCurriculum(streamFromFiles.skip(1).findFirst().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
