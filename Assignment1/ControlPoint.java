package Assignment1;

import javafx.beans.value.ChangeListener;
import Assignment1.SelectionArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ControlPoint extends Circle {

	;
	public ControlPoint(double x, double y) {
		super(x,y,5,Color.BLACK );
	}

	public void addChangeListener(ChangeListener<Number> x, ChangeListener<Number> y) {

		centerXProperty().addListener(x);
		centerYProperty().addListener(y);
	}

	public void translate(double dX, double dY) {
		centerXProperty().set(centerXProperty().get() + dX);
		centerYProperty().set(centerYProperty().get() + dY);
	}

}
