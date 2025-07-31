package data;

import java.math.BigDecimal;

public class Point {
    private BigDecimal x;
    private BigDecimal y;

    public Point() {
        this.x = new BigDecimal(0);
        this.y = new BigDecimal(0);
    }

    public Point(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public BigDecimal getX() {
        return this.x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return this.y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }
}
