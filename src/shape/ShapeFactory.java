package shape;

import java.util.List;

import screen.Point;
import shape.Shape;

public class ShapeFactory {
	public static Shape createShape(Shape.shapeType shapeType, Point point, List<Double> parameters) {
		Shape shape;
		switch (shapeType) {
		case SQUARE: {
			shape = new Square(point.getX(), point.getY(), parameters.get(0));
			break;
		}
		case RECTANGLE: {
			shape = new Rectangle(point.getX(), point.getY(), parameters.get(0), parameters.get(1));
			break;
		}
		case TRIANGLE: {
			shape = new Triangle(point.getX(), point.getY(), parameters.get(0), parameters.get(1));
			break;
		}
		case CIRCLE: {
			shape = new Circle(point.getX(), point.getY(), parameters.get(0));
			break;
		}
		default: {
			shape = null;
		}
		}
		return shape;
		}
}