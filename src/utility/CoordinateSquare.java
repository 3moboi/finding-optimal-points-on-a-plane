package utility;

import data.Point;
import data.InputData;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CoordinateSquare {
    private final BigDecimal X_MIN;
    private final BigDecimal Y_MIN;
    private final BigDecimal RADIUS;
    private final BigInteger NUMBER_OF_SQUARES_IN_ROW;

    public CoordinateSquare(InputData inputData){
        X_MIN = inputData.getBounds().getMinX();
        Y_MIN = inputData.getBounds().getMinY();
        RADIUS = inputData.getRadius();
        //нужно округление в большую сторону, чтобы не потерять нужную информацию
        NUMBER_OF_SQUARES_IN_ROW = findDistanceBetweenPointsDividedByRadius
                (inputData.getBounds().getMaxX(),inputData.getBounds().getMinX()).add(BigInteger.ONE);
    }

    // (x - x0)/r
    private BigInteger findDistanceBetweenPointsDividedByRadius(BigDecimal point, BigDecimal startingPoint){
        BigDecimal result = point.subtract(startingPoint);
        MathContext mc = new MathContext(5, RoundingMode.FLOOR);
        result = result.divide(RADIUS, mc);
        return result.toBigInteger();
    }

    public BigInteger findSquareNumberByCoordinates(Point point){
        return findSquareNumberByRowAndColumn(getRowNumber(point), getColumnNumber(point));
    }

    private BigInteger getColumnNumber(Point point){
        return findDistanceBetweenPointsDividedByRadius(point.getX(), X_MIN);
    }

    private BigInteger getRowNumber(Point point){
        return findDistanceBetweenPointsDividedByRadius(point.getY(), Y_MIN);
    }

    private BigInteger findSquareNumberByRowAndColumn(BigInteger rowNumber, BigInteger columnNumber){
        return rowNumber.multiply(NUMBER_OF_SQUARES_IN_ROW).add(columnNumber);
    }

    public List <BigInteger>  searchForNumbersOfNeighboringSquares(Point point){
        List <BigInteger> squareNumbers = new ArrayList<>();
        for(int i = -1; i <= 1; i++){

            BigInteger bigI = BigInteger.valueOf(i);
            BigInteger row = getRowNumber(point).add(bigI);

            for(int j = -1; j <= 1 && (row.compareTo(BigInteger.ZERO) >= 0); j++) {

                BigInteger bigJ = BigInteger.valueOf(j);
                BigInteger column = getColumnNumber(point).add(bigJ);

                if(column.compareTo(BigInteger.ZERO)>= 0 && column.compareTo(NUMBER_OF_SQUARES_IN_ROW) < 0) {
                    squareNumbers.add(findSquareNumberByRowAndColumn(row,column));
                }
            }
        }
        return squareNumbers;
    }

}
