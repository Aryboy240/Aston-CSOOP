package uk.ac.aston.oop.inheritance.shapes;

import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

/**
 * Shape, specified as upper left corner, width, and height.
 */
public class Shape {
	/**
	 * Upper left X coordinate of rectangle.
	 * Upper left y coordinate of rectangle.
     * Width of rectangle.
     * Height of rectangle.
     */
	private double upperLeftX, upperLeftY;
	private double width, height;
	
	/**
	 * Creates a new instance.
	 *
	 * @param upperLeftX X coordinate of the upper left corner.
	 * @param upperLeftY Y coordinate of the upper left corner.
	 * @param width Width of the shape.
     * @param height Height of the shape.
	 */
	public Shape(double upperLeftX, double upperLeftY, double width, double height) {
		this.upperLeftX = upperLeftX;
		this.upperLeftY=upperLeftY;
		this.width = width;
		this.height= height;
	}
	
	/**
	 * Returns the X coordinate of the upper left corner.
	 *
	 * @return X coordinate of upper left corner.
	 */
	public double getX() {
		return this.upperLeftX;
	}
	
	/**
     * Returns the Y coordinate of the upper left corner.
     *
     * @return Y coordinate of upper left corner.
     */
	public double getY() {
		return this.upperLeftY;
	}
	
	/**
     * Returns the width of the shape.
     *
     * @return Width of the shape.
     */
	public double getWidth() {
		return this.width;
	}
	
	/**
     * Returns the height of the shape.
     *
     * @return Height of the shape.
     */
	public double getHeight() {
		return this.height;
	}
	
	/**
     * Draws the shape using the provided GraphicsContextWrapper.
     *
     * @param gc GraphicsContextWrapper for drawing.
     */
    public void draw(GraphicsContextWrapper gc) {
        System.out.println("Cannot really draw a Shape.");
    }
}
