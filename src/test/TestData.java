package test;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class TestData {

    private static final String FILE_PATH = "input.txt";

    //private static final int NUMBER_OF_TEST = 6;

    private static final Random random = new Random();

    public static void generateRandomTest(int clientCount, double radius) {

        try (FileWriter output = new FileWriter(FILE_PATH)) {
            output.write(clientCount+" "+ radius + "\r\n");

            for (int i = 0; i < clientCount; i++) {
                double x = -100 + 200 * random.nextDouble();
                double y = -100 + 200 * random.nextDouble();
                output.write(String.format(Locale.US, "%.6f %.6f%n", x, y));
            }
        }
        catch (IOException exception) {
            System.out.println("Ошибка записи файла: " + exception);
        }
    }

    public static void generateTestWithMinimumNumberOfClients() {

        try (FileWriter output = new FileWriter(FILE_PATH)) {
            // минимальное кол-во клиентов
            output.write("1 1.0\n");
            output.write("0 0\n");
        }
        catch (IOException exception) {
            System.out.println("Ошибка записи файла: " + exception);
        }
    }

    public static void generateTestClientsAtOnePoint() {
        try (FileWriter output = new FileWriter(FILE_PATH)) {
            // Все клиенты в одной точке
            output.write("10 2.0\n");
            for (int i = 0; i < 10; i++) {
                output.write("5.0 5.0\n");
            }
        }
        catch (IOException exception) {
            System.out.println("Ошибка записи файла: " + exception);
        }
    }

    public static void generateTestClientsOnBorderOfRadius() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            // Клиенты на границе радиуса
            writer.write("5 10.0\n");
            writer.write("0 0\n");
            writer.write("10 0\n");
            writer.write("0 10\n");
            writer.write("-10 0\n");
            writer.write("0 -10\n");
        }
        catch (IOException exception) {
            System.out.println("Ошибка записи файла: " + exception);
        }
    }

    public static void generateTestForAllClientsFurtherAwayFromRadius() {
        int clientCount = 10;
        double radius = 5.0;
        // все точки на расстоянии > r

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(clientCount + " " + radius + "\n");

            // Генерация точек на сетке с шагом > 2R (гарантирует отсутствие пересечений)
            double step = 2 * radius + 1.0; // Минимальное расстояние между точками
            for (int i = 0; i < clientCount; i++) {
                double x = i * step;
                double y = i * step;
                String line = String.format(Locale.US, "%.6f %.6f\n", x, y);
                writer.write(line);
            }
        }
        catch (IOException exception) {
            System.out.println("Ошибка записи файла: " + exception);
        }
    }

        public static void generateSimpleTest() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            //тест из задания
            writer.write("10 3.000000\n");
            writer.write("3.168070 1.752490\n");
            writer.write("0.500730 6.436580\n");
            writer.write("0.089300 0.112720\n");
            writer.write("2.275440 7.508780\n");
            writer.write("0.779230 4.377090\n");
            writer.write("0.644400 1.381650\n");
            writer.write("1.844920 1.430420\n");
            writer.write("8.079870 5.225030\n");
            writer.write("7.823270 5.317290\n");
            writer.write("1.788400 5.426120\n");
        } catch (IOException exception) {
            System.out.println("Ошибка записи файла: " + exception);
        }
    }

}
