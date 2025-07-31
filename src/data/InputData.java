package data;

import java.math.BigDecimal;

public class InputData {
    private int clientCount;
    private BigDecimal radius;
    private Bounds bounds;
    private Point[] coords;

    public InputData() {
        clientCount = 0;
        bounds = new Bounds();
        coords = new Point[0];
        radius = new BigDecimal(0);
    }

    public int getClientCount() {
        return this.clientCount;
    }

    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }

    public BigDecimal getRadius() {
        return this.radius;
    }

    public void setRadius(BigDecimal radius) {
        this.radius = radius;
    }

    public Bounds getBounds() {
        return this.bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public Point[] getClientCoords() {
        return this.coords;
    }

    public void setClientCoords(Point[] coords) {
        this.coords = coords;
        for (Point coordinate: coords) {
            bounds.updateBounds(coordinate.getX(), coordinate.getY());
        }
    }
}
