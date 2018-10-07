package Assignment1;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import Assignment1.PolyShape;
import Assignment1.SelectionArea;
import Assignment1.ControlPoint;

public class MapArea extends Pane {

	private double startX;
	private double startY;
	private ToolState tool;
	private PolyShape chosenShape;
	private ObservableList<Node> children;

	public MapArea() {
		super();
		tool = ToolState.getState();
		children = this.getChildren();
		registerMouseEvents();

	}

	private void registerMouseEvents() {
		addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressed);
		addEventHandler(MouseEvent.MOUSE_RELEASED, this::released);
		addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragged);
	}

	private void pressed(MouseEvent e) {
		e.consume();
		startX = e.getX();
		startY = e.getY();
		switch (ToolState.getState().getTool()) {
		case ROOM:
			int option = ToolState.getState().getOption();
			if (option == 2) {

				
				
				ControlPoint controlPoint = new ControlPoint(startX, startY);
				chosenShape = new PolyShape(controlPoint);
				chosenShape.setFill(Color.LIGHTGRAY);
				chosenShape.setStroke(Color.GRAY);
				chosenShape.setStrokeWidth(2);
				chosenShape.registerControlPoints();

			}
			if (option == 4) {
				chosenShape = new PolyShape(4);
				chosenShape.setFill(Color.LIGHTGRAY);
				chosenShape.setStroke(Color.GRAY);
				chosenShape.setStrokeWidth(2);
				SelectionArea selection = new SelectionArea(chosenShape);
				selection.start(startX, startY);
				selection.end(startX, startY);
			}
			getChildren().add(chosenShape);
			break;
		case ERASE:

		case MOVE:
			int option2 = ToolState.getState().getOption();
			if (option2 == 2) {

			} else

			if (option2 == 4) {

			}
			break;
		case SELECT:
			break;

		default:
			throw new UnsupportedOperationException(
					"Cursor for Tool \"" + activeTool().name() + "\" is not implemented");
		}

	}

	private void dragged(MouseEvent e) {
		e.consume();
		switch (ToolState.getState().getTool()) {
		case ROOM:
			int option = ToolState.getState().getOption();
			if (option == 2) {

				if (chosenShape != null) {

				}
			}
			if (option == 4) {

			}
			getChildren().add(chosenShape);
			break;
		case ERASE:
			break;
		case MOVE:
			// start only needs to be updated for move , what we discussed in class we with
			// out the need of PolyShape
			startX = e.getX();
			startY = e.getY();
			break;

		default:
			throw new UnsupportedOperationException(
					"Cursor for Tool \"" + activeTool().name() + "\" is not implemented");
		}
		chosenShape = null;
	}

	private void released(MouseEvent e) {
		e.consume();
		switch (activeTool()) {
		case MOVE:
		case SELECT:
		case ERASE:
		case ROOM:
			break;
		default:
			throw new UnsupportedOperationException(
					"Release for Tool \"" + activeTool().name() + "\" is not implemneted");
		}
		chosenShape = null;
	}

	private double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	private Tools activeTool() {
		return tool.getTool();
	}

}