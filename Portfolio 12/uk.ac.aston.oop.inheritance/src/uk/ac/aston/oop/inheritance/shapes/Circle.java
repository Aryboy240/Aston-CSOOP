package uk.ac.aston.oop.inheritance.shapes;

/**
 * Circle, specified as center + radius.
 */
public class Circle extends Ellipse{
	
	/**
     * Creates a new circle instance.
     *
     * @param centerX X coordinate of the center.
     * @param centerY Y coordinate of the center.
     * @param radius Radius of the circle.
     */
	public Circle(double centerX, double centerY, double radius) {
		super(centerX - radius, centerY - radius, radius * 2, radius * 2);
	}
	
	/**
	 * Returns the radius of the circle.
	 *
	 * @return half the width of the ellipse.
	 */
	public double getRadius() {
	    return getWidth() / 2;
	}
}
