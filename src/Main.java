import data.OutputData;
import data.Solution;
import io.reading.InputDataReader;
import io.writing.OutputDataWriter;
import solver.DivideAndConquerSolver;
import solver.Solver;

/**
 Подготовка : Координатную плоскость разбиваем на квадраты, сторона которого равна R
 *      Пробегаем по точкам:
 *      По координатам точки определяем номер квадарата
 *      Заполняем хеш-таблицу: ключ - номер квадрата, значение - список точек, которые находятся в квадрате (порядковые номера клиентов)
 * Решение :
 *      Пробегаем по точкам (station):
 *      По координатам точки определяем номера соседних квадратов(таких 9)
 *      соседние квадраты - это квадраты сверху,снизу,влево,вправо и по диагонали, а так же квадрат, в котором находится точка
 *      Пробегаем по соседним квадратам:
 *      Если квадрат не пуст(есть номер квадрата в хеш-таблице)
 *      Считаем расстояние точек из данного квадрата(client) с точкой station
 *      Если расстояние меньше или равно R, увеличиваем счетчик servicedClients
 *      Когда пробежались по соседним квадратам, добавляем порядковый номер station и servicedClients в кучу minHeap(10 элементов)
 *      Выводим в файл minHeap
 * Проверка расстояния между точками:
 *      Проверка осуществляется через уравнение окружности где координаты центра - station, радиус - R
 */
public class Main {
    public static void main(String[] args) {
        //Test.test();

        final String INPUT_FILE_PATH = "input.txt";
        final String OUTPUT_FILE_PATH = "output.txt";

        InputDataReader inputReader = new InputDataReader(INPUT_FILE_PATH);
        Solver solver = new DivideAndConquerSolver(inputReader.readFromFile());
        Solution solution = solver.getSolution();
        OutputData outputData = new OutputData(solution);
        OutputDataWriter outputWriter = new OutputDataWriter(OUTPUT_FILE_PATH);
        outputWriter.writeToFile(outputData);
    }
}