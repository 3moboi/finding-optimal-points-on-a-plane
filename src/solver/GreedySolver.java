package solver;

import data.InputData;
import data.Point;
import data.Solution;
import data.Variant;
import utility.DistanceChecker;

import java.math.BigDecimal;

public class GreedySolver implements Solver {
    private final Point[] CLIENT_COORDS;
    private final int CLIENT_COUNT;
    private final BigDecimal RADIUS;

    public GreedySolver(InputData inputData){
        CLIENT_COUNT = inputData.getClientCount();
        RADIUS = inputData.getRadius();
        CLIENT_COORDS = inputData.getClientCoords();
    }

    public Solution getSolution() {
        Solution solution = new Solution();
        for(int i = 0; i < CLIENT_COUNT; i++) {
            int servicedClients = 0;
            Point center = CLIENT_COORDS[i];

            for(int j = 0; j < CLIENT_COUNT;j++) {
                if(i == j) {
                    continue;
                }

                Point client = CLIENT_COORDS[j];

                if(DistanceChecker.isClientNearStation(center, client, RADIUS)) {
                    servicedClients++;
                }
            }

            solution.addVariant(new Variant(i, servicedClients));
        }

        return solution;
    }
}
