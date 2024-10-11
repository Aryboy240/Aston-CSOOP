package uk.ac.aston.oop.inheritance.shapes;

import uk.ac.aston.oop.inheritance.util.GraphicsContextWrapper;

/**
 * Frame, specified as upper left corner, width, and height.
 */
public class Frame extends Shape{
	
	 /**
	 * Outer rectangle of the frame.
     * Inner rectangle of the frame.
     */
	protected Rectangle outerRectangle, innerRectangle;
	
	/**
     * Creates a new frame instance.
     *
     * @param upperLeftX X coordinate of the upper left corner.
     * @param upperLeftY Y coordinate of the upper left corner.
     * @param width Width of the frame.
     * @param height Height of the frame.
     */
	public Frame(double upperLeftX, double upperLeftY, double width, double height) {
		super(upperLeftX, upperLeftY, width, height);
		this.outerRectangle = new Rectangle(upperLeftX, upperLeftY, width, height);
		this.innerRectangle = new Rectangle(upperLeftX + FRAME_THICKNESS, upperLeftY + FRAME_THICKNESS, width - 2 * FRAME_THICKNESS, height - 2 * FRAME_THICKNESS);
	}
	
	/**
     * Thickness of the frame.
     */
	private static final int FRAME_THICKNESS = 10;
	
	/**
     * Draws the shape using the provided GraphicsContextWrapper.
     *
     * @param gc GraphicsContextWrapper for drawing.
     */
	public void draw(GraphicsContextWrapper gc) {
		outerRectangle.draw(gc);
        innerRectangle.draw(gc);
	}
	
}
