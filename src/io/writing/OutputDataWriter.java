package io.writing;

import data.OutputData;
import data.Variant;

import java.io.FileWriter;
import java.io.IOException;

public class OutputDataWriter extends BaseDataWriter<OutputData> {
    public OutputDataWriter(String filePath) {
        super(filePath);
    }

    public void writeToFile(OutputData data) {
        var indexValuePairs = data.getVariantList();
        try (FileWriter output = new FileWriter(FILE_PATH)) {
            for(Variant variant : indexValuePairs) {
                output.write(variant.getIndex() + " " + variant.getValue() + "\n");
            }
        }
        catch (IOException exception) {
            System.out.println("Ошибка записи файла: " + exception);
        }
    }
}
