package uk.ac.aston.oop.inheritance.shapes;

import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

import javafx.scene.paint.Color;

/**
 * Filled Rectangle, specified as upper left corner, width, height, and color.
 */
public class FilledRectangle extends Rectangle {
	
	/**
	 * FilledRectangle, a variant of Rectangle with a fill color.
	 */
	private Color fill;
	
	/**
     * Creates a new filled rectangle instance.
     *
     * @param fill Fill color of the rectangle.
     * @param ulX X coordinate of the upper left corner.
     * @param ulY Y coordinate of the upper left corner.
     * @param width Width of the rectangle.
     * @param height Height of the rectangle.
     */
	public FilledRectangle(Color fill, double ulX, double ulY, double width, double height) {
        super(ulX, ulY, width, height);
        this.fill = fill;
    }
	
	/**
	 * Gets the fill color of the rectangle.
	 * 
	 * @return rectangle color.
	 */
	public Color getFill() {
		return fill;
	}
	
	/**
     * Draws the shape using the provided GraphicsContextWrapper.
     *
     * @param gc GraphicsContextWrapper for drawing.
     */
	@Override
	public void draw(GraphicsContextWrapper gc) {
		super.draw(gc);
		gc.fill(getFill());
		gc.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
