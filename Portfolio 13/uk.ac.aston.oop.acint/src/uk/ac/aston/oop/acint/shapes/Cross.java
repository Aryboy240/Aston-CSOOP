package uk.ac.aston.oop.acint.shapes;

import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;

public class Cross implements Drawable {
    protected static final int SIZE = 20;
    protected double centerX, centerY;

    public Cross(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void draw(GraphicsContextWrapper gc) {
        gc.line(centerX - SIZE/2, centerY - SIZE/2, centerX + SIZE/2, centerY + SIZE/2);
        gc.line(centerX + SIZE/2, centerY - SIZE/2, centerX - SIZE/2, centerY + SIZE/2);
    }

    @Override
    public void move(GraphicsContextWrapper gc, double dx, double dy) {
        centerX += dx;
        centerY += dy;

        // Clip the center X coordinate if it's beyond the right edge of the screen
        if (centerX + SIZE/2 > gc.width()) {
            centerX = gc.width() - SIZE/2;
        }

        // Clip the center Y coordinate if it's beyond the bottom edge of the screen
        if (centerY + SIZE/2 > gc.height()) {
            centerY = gc.height() - SIZE/2;
        }
    }
}