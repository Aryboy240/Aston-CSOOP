package uk.ac.aston.oop.acint.shapes;

import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;

public abstract class Shape implements Drawable {

	private double upperLeftX, upperLeftY;
	protected double width, height;

	public Shape(double ulX, double ulY, double width, double height) {
		this.upperLeftX = ulX;
		this.upperLeftY = ulY;
		this.width  = width;
		this.height = height;
	}

	public double getX() { return upperLeftX; }

	public double getY() { return upperLeftY; }

	public double getWidth()  { return width;  }

	public double getHeight() { return height; }
	
	@Override
	public void move(GraphicsContextWrapper gc, double dx, double dy) {
		this.upperLeftX += dx;
		this.upperLeftY += dy;
		
		// Clip the upper left X coordinate if it's beyond the right edge of the screen
        if (upperLeftX + width > gc.width()) {
            upperLeftX = gc.width() - width;
        }

        // Clip the upper left Y coordinate if it's beyond the bottom edge of the screen
        if (upperLeftY + height > gc.height()) {
            upperLeftY = gc.height() - height;
        }
	}

}
