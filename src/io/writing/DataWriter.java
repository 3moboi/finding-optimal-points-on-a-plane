package io.writing;

public interface DataWriter<T> {
    public void writeToFile(T data);
}
