package uk.ac.aston.oop.inheritance.shapes;

import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

/**
 * Ellipse, specified as upper left corner, width, and height.
 */
public class Ellipse extends Shape {
	
	 /**
     * Creates a new ellipse instance.
     *
     * @param upperLeftX X coordinate of the upper left corner.
     * @param upperLeftY Y coordinate of the upper left corner.
     * @param width Width of the ellipse.
     * @param height Height of the ellipse.
     */
	public Ellipse(double upperLeftX, double upperLeftY, double width, double height) {
		super (upperLeftX, upperLeftY, width, height);
	}
	
	/**
     * Draws the shape using the provided GraphicsContextWrapper.
     *
     * @param gc GraphicsContextWrapper for drawing.
     */
	@Override
	public void draw(GraphicsContextWrapper gc) {
		gc.oval(getX(), getY(), getWidth(), getHeight());
	}
}
