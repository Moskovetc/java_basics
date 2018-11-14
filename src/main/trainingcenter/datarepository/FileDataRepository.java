package main.trainingcenter.datarepository;

import java.util.List;

public class FileDataRepository implements IDataRepository {
    private final String filePath;
    public FileDataRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List getData() {
        return null;
    }
}
