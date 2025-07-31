package solver;

import data.*;
import utility.CoordinateSquare;
import utility.DistanceChecker;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DivideAndConquerSolver implements Solver {
    private final Hashtable <BigInteger, ArrayList<Integer>> HASH_TABLE;
    private final CoordinateSquare COORDINATE_SQUARE;
    private final Point[] CLIENT_COORDS;
    private final int CLIENT_COUNT;
    private final BigDecimal RADIUS;

    public DivideAndConquerSolver(InputData inputData){
        CLIENT_COUNT = inputData.getClientCount();
        RADIUS = inputData.getRadius();
        CLIENT_COORDS = inputData.getClientCoords();
        HASH_TABLE = new Hashtable<>();
        COORDINATE_SQUARE = new CoordinateSquare(inputData);
    }

    public Solution getSolution() {
        Solution solution = new Solution();

        if(CLIENT_COUNT <= 1) {
            return solution;
        }

        for(int i = 0; i < CLIENT_COUNT;i++) {
            Point center = CLIENT_COORDS[i];
            BigInteger square = COORDINATE_SQUARE.findSquareNumberByCoordinates(center);

            if (!HASH_TABLE.containsKey(square)) {
                HASH_TABLE.put(square, new ArrayList<>());
            }

            HASH_TABLE.get(square).add(i);
        }

        for(int i = 0; i < CLIENT_COUNT; i++){
            Point station = CLIENT_COORDS[i];
            solution.addVariant(new Variant(i, clientsCountServedByStation(station)));
        }

        return solution;
    }

    public int clientsCountServedByStation(Point station){

        // не считая самого клиента, у которого строится станция
        int servicedClients = -1;

        List <BigInteger> neighboringSquares = COORDINATE_SQUARE.searchForNumbersOfNeighboringSquares(station);
        //квадратов не больше 9

        for(BigInteger square : neighboringSquares){
            if (HASH_TABLE.containsKey(square)) {
                List <Integer> neighboringPoints = HASH_TABLE.get(square);
                for(Integer neighbour : neighboringPoints){
                    if(DistanceChecker.isClientNearStation(station, CLIENT_COORDS[neighbour], RADIUS)) {
                        servicedClients++;
                    }
                }
            }
        }

        return servicedClients;
    }
}
