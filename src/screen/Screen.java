package screen;

import java.util.ArrayList;
import java.util.List;

import shape.Shape;
import shape.ShapeFactory;

public class Screen {
	final double XMAX;
	final double YMAX;
	List<Shape> shapeList = new ArrayList<Shape>();
	Point point;

	public Screen(double x, double y) {
		XMAX = x;
		YMAX = y;
	}

	/**
	 * Add a shape on the screen
	 * 
	 * @param shapeType        contains type of the shape should be added on the
	 *                         screen
	 * @param origin           left corner point of the shape
	 * @param parameters contains parameter list for shape
	 * @return returns true if shape to be added on screen
	 */
	public boolean addShape(Shape.shapeType shapeType, Point origin, List<Double> parameters) {
		boolean isAdded = false;
		if (origin.getX() >= XMAX || origin.getX() <= 0 || origin.getY() <= 0 || origin.getY() >= YMAX) {
			return isAdded;
		}
		if (ShapeFactory.createShape(shapeType, origin, parameters) != null) {
			shapeList.add(ShapeFactory.createShape(shapeType, origin, parameters));
			isAdded = true;
		}
		return isAdded;
	}

	/**
	 * deletes first shape from listOfShape on screen whose shapeType and Origin
	 * matches with arguments.
	 * 
	 * @param shapeType contains type of shape to be deleted
	 * @param origin    contains origin of shape
	 * @return returns true if shape is deleted otherwise false
	 */
	public boolean deleteShape(Shape.shapeType shapeType, Point origin) {
		boolean isDeleted = false;
		for (Shape shape : shapeList) {
			if (shapeType == shape.getShapeType() && shape.getOrigin().getX() == origin.getX() && shape.getOrigin().getY() == origin.getY() ) {
				shapeList.remove(shape);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	/**
	 * delete all shapes of given type from screen
	 * @param ShapeType
	 * @return true if shapes are deleted
	 */
	public boolean deleteAllShapesOfSpecifiedType(Shape.shapeType shapeType) {
		boolean isDeleted = false;
		for (Shape shape : shapeList) {
			if (shape.getShapeType().equals(shapeType)) {
				shapeList.remove(shape);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	/**
	 * To get list of all shapes which encloses given point within it
	 * 
	 * @param point contains point that is enclosed by shapes
	 * @return listOfShapeEnclosingAPoint
	 */
	public List<Shape> getListOfShapeEnclosingAPoint(Point point) {
		List<Shape> listOFShapeEnclosingAPoint = new ArrayList<Shape>();
		for (Shape shape : shapeList) {
			boolean isEnclosed = false;
			isEnclosed = shape.isPointEnclosed(point);
			if (isEnclosed) {
				listOFShapeEnclosingAPoint.add(shape);
			}
		}
		return listOFShapeEnclosingAPoint;
	}

	/**
	 * Sort list of shapes in ascending order on various basis
	 * 
	 * @param basedOn contains various basis for sorting
	 * @return returns list of shape in ascending order
	 */
	public List<Shape> sortListOfShape(String basedOn) {
		List<Shape> sortedListOfShape = new ArrayList<Shape>();
		switch (basedOn) {
		case "area" :
			sortedListOfShape = Sort.sortArea(shapeList);
			break;
		case "perimeter":
			sortedListOfShape = Sort.sortPerimeter(shapeList);
			break;
		case "timeStamp":
			sortedListOfShape = Sort.sortTimeStamp(shapeList);
			break;
		case "originDistance":
			sortedListOfShape = Sort.sortOriginDistance(shapeList);
			break;
		default:
			throw new AssertionError("list can't be sorted on the basis of " + basedOn);
		}
		return sortedListOfShape;
	}

}
