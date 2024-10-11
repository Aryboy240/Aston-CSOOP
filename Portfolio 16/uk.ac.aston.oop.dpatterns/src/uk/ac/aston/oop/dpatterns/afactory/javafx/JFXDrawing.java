package uk.ac.aston.oop.dpatterns.afactory.javafx;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import uk.ac.aston.oop.dpatterns.afactory.Drawing;
	
public class JFXDrawing implements Drawing{
	
	private javafx.scene.shape.Rectangle rectangle;
	
	public JFXDrawing(Group container, int width, int height) {
		this.rectangle = new javafx.scene.shape.Rectangle();
		container.getChildren().add(rectangle);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
	}
	
	public void setFill(int r, int g, int b) {
		Color color = Color.rgb(r, g, b);
        rectangle.setFill(color);
	}
	
	public javafx.scene.shape.Rectangle getShape() {
        return rectangle;
    }
}
