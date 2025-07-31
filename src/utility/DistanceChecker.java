package utility;

import data.Point;

import java.math.BigDecimal;

public class DistanceChecker {
    public static boolean isClientNearStation(Point station, Point client, BigDecimal radius){
        //уравнение окружности
        // (x-x0)
        BigDecimal x = client.getX().subtract(station.getX());
        // (y-y0)
        BigDecimal y = client.getY().subtract(station.getY());

        //(x-x0)^2  (y-y0)^2
        x = x.pow(2);
        y = y.pow(2);

        //(x-x0)^2  + (y-y0)^2
        BigDecimal sum = x.add(y);

        //sum <= r^2
        int comparisonResult = radius.pow(2).compareTo(sum);
        return comparisonResult >= 0;
    }
}
