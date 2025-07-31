package test;

import data.Solution;
import io.reading.InputDataReader;
import solver.DivideAndConquerSolver;
import solver.GreedySolver;
import solver.Solver;

public class Test {
    final static String INPUT_FILE_PATH = "input.txt";
    public static void test(){

        TestData.generateRandomTest(50, 4.5001);
        System.out.println("RandomTest: "+compareSolutions());

        TestData.generateTestWithMinimumNumberOfClients();
        System.out.println("TestWithMinimumNumberOfClients: "+compareSolutions());

        TestData.generateTestClientsAtOnePoint();
        System.out.println("TestClientsAtOnePoint: "+compareSolutions());

        TestData.generateTestClientsOnBorderOfRadius();
        System.out.println("TestClientsOnBorderOfRadius: "+compareSolutions());

        TestData.generateTestForAllClientsFurtherAwayFromRadius();
        System.out.println("TestForAllClientsFurtherAwayFromRadius: "+compareSolutions());

        TestData.generateSimpleTest();
        System.out.println("SimpleTest: " + compareSolutions());
    }

    public static boolean compareSolutions(){
        InputDataReader inputReader = new InputDataReader(INPUT_FILE_PATH);

        Solver solver = new DivideAndConquerSolver(inputReader.readFromFile());
        Solution solution = solver.getSolution();

        Solver solverTest = new GreedySolver(inputReader.readFromFile());
        Solution solutionTest = solverTest.getSolution();

        boolean isEqual = ListComparator.areListsEqual(solution.getResult(), solutionTest.getResult());
        return isEqual;
    }
}
