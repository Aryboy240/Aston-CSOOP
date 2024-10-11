package uk.ac.aston.oop.acint.shapes;

import uk.ac.aston.oop.acint.util.GraphicsContextWrapper;

public interface Drawable {
	void draw(GraphicsContextWrapper gc);
	void move(GraphicsContextWrapper gc, double dx, double dy);
}
