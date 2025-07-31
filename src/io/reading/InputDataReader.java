package io.reading;

import data.Point;
import data.InputData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class InputDataReader extends BaseDataReader<InputData> {
    public InputDataReader(String filePath) {
        super(filePath);
    }

    public InputData readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            InputData inputData = new InputData();
            String bufferString = reader.readLine();
            String[] stringValues = bufferString.split(" ");

            inputData.setClientCount(Integer.parseInt(stringValues[0]));
            inputData.setRadius(new BigDecimal(stringValues[1]));

            Point[] coords = new Point[inputData.getClientCount()];
            for (int i = 0; i < coords.length; i++) {
                bufferString = reader.readLine();
                stringValues = bufferString.split(" ");
                coords[i] = new Point(new BigDecimal(stringValues[0]), new BigDecimal(stringValues[1]));
            }

            inputData.setClientCoords(coords);

            return inputData;
        }
        catch (IOException exception) {
            System.out.println("Ошибка чтения файла: " + exception);
        }

        return null;
    }
}
