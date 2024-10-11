package uk.ac.aston.oop.inheritance.shapes;

import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

/**
 * Rectangle, specified as upper left corner, width, and height.
 */
public class Rectangle extends Shape {
	/**
     * Creates a new rectangle instance.
     *
     * @param ulX X coordinate of the upper left corner.
     * @param ulY Y coordinate of the upper left corner.
     * @param width Width of the rectangle.
     * @param height Height of the rectangle.
     */
    public Rectangle(double ulX, double ulY, double width, double height) {
        super(ulX, ulY, width, height);
    }
    
    /**
     * Draws the shape using the provided GraphicsContextWrapper.
     *
     * @param gc GraphicsContextWrapper for drawing.
     */
    @Override
    public void draw(GraphicsContextWrapper gc) {
    	gc.lineWidth(5);
        gc.rect(getX(), getY(), getWidth(), getHeight());
    }
}