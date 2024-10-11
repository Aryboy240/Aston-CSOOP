package uk.ac.aston.oop.dpatterns.afactory.javafx;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import uk.ac.aston.oop.dpatterns.afactory.Circle;

public class JFXCircle implements Circle{
	
	private javafx.scene.shape.Circle circle;
	
	public JFXCircle(Group container, int cx, int cy, int radius) {
		this.circle = new javafx.scene.shape.Circle();
		container.getChildren().add(circle);
        circle.setCenterX(cx);
        circle.setCenterY(cy);
        circle.setRadius(radius);
	}
	
	public void setFill(int r, int g, int b) {
        Color color = Color.rgb(r, g, b);
        circle.setFill(color);
	}
	
	public javafx.scene.shape.Circle getShape() {
        return circle;
    }
}
