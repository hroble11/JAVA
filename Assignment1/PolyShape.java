package Assignment1;

import java.util.function.DoubleUnaryOperator;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.*
import javafx.scene.shape.Polygon;


public class PolyShape extends Polygon {

	private final ObservableList<Double> pPoints;

	private int sides;
	private double angle;
	private double dX, dY;
	private double x1, y1;

	private ControlPoint[] cPoints;

	public PolyShape(int sides) {
		super();
		pPoints = getPoints();
		this.sides=sides;
	}

	private void calculatePoints() {
		for (int side = 0; side < sides; side++) {
			pPoints.addAll(point(Math::cos, dX / 2, angle, side, sides) + x1,
					point(Math::sin, dY / 2, angle, side, sides) + y1);
		}
	}

	private double radianShift(double x1, double y1, double x2, double y2) {
		return Math.atan2(y2 - y1, x2 - x1);
	}

	private double point(DoubleUnaryOperator operation, double radius, double shift, double side, final int SIDES) {
		return radius * operation.applyAsDouble(shift + side * 2.0 * Math.PI / SIDES);
	}

	public void registerControlPoints() {
		cPoints = new ControlPoint[sides];
		for (int i = 0; i < pPoints.size(); i += 2) {

			cPoints[1 / 2] = new ControlPoint(pPoints.get(i), pPoints.get(i + 1));
			final int j = i;
			cPoints[1 / 2].addChangeListener((value, oldValue, newV) -> pPoints.set(j, newV.doubleValue()),
					(value, oldValue, newV) -> pPoints.set(j + 1, newV.doubleValue()));
		}
		// to register control points create an array of control points,
		// have in mind every two points the polygon class getPoints() counts as one
		// control point.

		// loop through all points of polygon getPoints() index by index,
		// again dont forget every 2 indices are considered one control point.

		// for every two indices manually add a ChangeListener to centerXProperty and
		// centerYProperty
		// of your control point which extends Circle.

		// each ChangeListener will updated the corresponding index inside of the
		// Polygon getPoints().
	}

	private double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	/**
	 * redraw the shape without the need to remake it. till all redrawing are done
	 * registerControlPoints should not be called.
	 */
	public void reDraw(double x1, double y1, double x2, double y2, boolean symmetrical) {
		radianShift(x1, y1, x2, y2);

		//if shape is symmetrical measure the distance between x1,y1 and x2,y2 and assign it to dx and dy
		if (symmetrical) {

			dX = distance(x1, y1, x2, y2);
			dY = distance(x1, y1, x2, y2);
		}
		if (!symmetrical) {
			dX = x1 - x2;
			dY = y1 - y2;
			x1 = x1 + ((x2 - x1) / 2);
			y1 = y1 + ((y2 - y1) / 2);

		}
		pPoints.clear();

		calculatePoints();
	}

	public Node[] getControlPoints() {
		return cPoints;
	}
}
