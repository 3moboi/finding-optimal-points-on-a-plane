package io.writing;

public abstract class BaseDataWriter<T> implements DataWriter<T> {
    protected final String FILE_PATH;

    public BaseDataWriter(String filePath) {
        this.FILE_PATH = filePath;
    }
}
