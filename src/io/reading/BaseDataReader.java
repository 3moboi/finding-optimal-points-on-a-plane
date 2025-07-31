package io.reading;

public abstract class BaseDataReader<T> implements DataReader<T> {
    protected final String FILE_PATH;

    public BaseDataReader(String filePath) {
        this.FILE_PATH = filePath;
    }
}
