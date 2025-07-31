package data;

import java.math.BigDecimal;

public class Bounds {
    private BigDecimal minX;
    private BigDecimal maxX;
    private BigDecimal minY;
    private BigDecimal maxY;

    public Bounds() {
        this.minX = new BigDecimal(0);
        this.maxX = new BigDecimal(0);
        this.minY = new BigDecimal(0);
        this.maxY = new BigDecimal(0);
    }

    public Bounds(BigDecimal minX, BigDecimal maxX, BigDecimal minY, BigDecimal maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public void updateBounds(BigDecimal x, BigDecimal y) {
        if (x.compareTo(minX) < 0) {
            this.minX = x;
        } else if (x.compareTo(maxX) > 0) {
            this.maxX = x;
        }

        if (y.compareTo(minY) < 0) {
            this.minY = y;
        }
        else if (y.compareTo(maxY) > 0) {
            this.maxY = y;
        }
    }

    public BigDecimal getMinX() {
        return this.minX;
    }

    public BigDecimal getMaxX() {
        return this.maxX;
    }

    public BigDecimal getMinY() {
        return this.minY;
    }

    public BigDecimal getMaxY() {
        return this.maxY;
    }
}
