package screen;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import shape.*;;

public class ScreenTest {
	Screen screen = new Screen(2000, 2000);
	List<Double> parameters;

	// test case for addShape()
	@Test
	public void testAddShape() {
		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		Point point = new Point(1, 2);
		boolean isAdded = screen.addShape(Shape.shapeType.SQUARE, point, parameters);
		assertEquals(true, isAdded);
	}
	/**
	 * testAddShapeShouldReturnFalseWhenCoordinatesAreNotInRange
	 */

	@Test
	public void negativeTestAddShape() {
		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		Point point = new Point(-1, 2010);
		boolean isAdded = screen.addShape(Shape.shapeType.CIRCLE, point, parameters);
		assertEquals(false, isAdded);
	}

	// test cases for deleteShape()
	@Test
	public void testDeleteShape() {
		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		Point point = new Point(1, 2);
		screen.addShape(Shape.shapeType.SQUARE, point, parameters);
		boolean isDeleted = screen.deleteShape(Shape.shapeType.SQUARE, point);
		assertEquals(true, isDeleted);
	}
	
	/**
	 * ShouldReturnFalseWhenTypeAndOriginNotMatches
	 */

	@Test
	public void negativeTestDeleteShape() {
		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		Point origin = new Point(1, 2);
		screen.addShape(Shape.shapeType.CIRCLE, origin, parameters);
		Point point = new Point(2, 3);
		boolean isDeleted = screen.deleteShape(Shape.shapeType.RECTANGLE, point);
		assertEquals(false, isDeleted);
	}

	@Test
	public void testDeleteShapeShouldReturnFalseWhenScreenIsEmpty() {
		Point point = new Point(1, 2);
		boolean isDeleted = screen.deleteShape(Shape.shapeType.RECTANGLE, point);
		assertEquals(false, isDeleted);
	}

	// Test cases for deleteAllShapeOfSpecifiedType()
	@Test
	public void testDeleteAll() {
		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		Point point = new Point(1, 2);
		screen.addShape(Shape.shapeType.CIRCLE, point, parameters);

		parameters = new ArrayList<Double>();
		parameters.add(4.0);
		point = new Point(3, 6);
		screen.addShape(Shape.shapeType.CIRCLE, point, parameters);

		boolean isRemoved = screen.deleteAllShapesOfSpecifiedType(Shape.shapeType.CIRCLE);
		;
		assertEquals(true, isRemoved);
	}

	@Test
	public void testDeleteAllShape() {
		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		parameters.add(3.3);
		Point point = new Point(1, 2);
		screen.addShape(Shape.shapeType.RECTANGLE, point, parameters);

		parameters = new ArrayList<Double>();
		parameters.add(4.0);
		point = new Point(3, 6);
		screen.addShape(Shape.shapeType.CIRCLE, point, parameters);

		boolean isRemoved = screen.deleteAllShapesOfSpecifiedType(Shape.shapeType.SQUARE);
		assertEquals(false, isRemoved);
	}

	// Test cases for sortListOfShape()
	@Test
	public void testSortArea() {
		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		parameters.add(3.3);
		Point point = new Point(1, 2);
		screen.addShape(Shape.shapeType.RECTANGLE, point, parameters);

		parameters = new ArrayList<Double>();
		parameters.add(4.0);
		point = new Point(3, 6);
		screen.addShape(Shape.shapeType.CIRCLE, point, parameters);

		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		point = new Point(1, 2);
		screen.addShape(Shape.shapeType.SQUARE, point, parameters);

		List<Shape> sortedList = screen.sortListOfShape("area");
		double[] actualOutput = new double[sortedList.size()];
		for (int i = 0; i < sortedList.size(); i++) {
			actualOutput[i] = sortedList.get(i).getArea();
		}
		double[] expectedOutput = { 4.0, 6.6, 50.24 };
		assertArrayEquals(expectedOutput, actualOutput, 1.50);
	}

	@Test
	public void testSortPerimeter() {
		parameters = new ArrayList<Double>();
		parameters.add(2.00);
		parameters.add(3.00);
		Point point = new Point(1, 2);
		screen.addShape(Shape.shapeType.RECTANGLE, point, parameters);

		parameters = new ArrayList<Double>();
		parameters.add(4.0);
		point = new Point(3, 6);
		screen.addShape(Shape.shapeType.CIRCLE, point, parameters);

		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		point = new Point(1, 2);
		screen.addShape(Shape.shapeType.SQUARE, point, parameters);

		List<Shape> sortedList = screen.sortListOfShape("perimeter");
		double[] actualOutput = new double[sortedList.size()];
		for (int i = 0; i < sortedList.size(); i++) {
			actualOutput[i] = sortedList.get(i).getPerimeter();
		}
		double[] expectedOutput = { 8.00, 10.00, 25.12 };
		assertArrayEquals(expectedOutput, actualOutput, 1.50);
	}

	@Test
	public void testSortOriginDistance() {
		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		parameters.add(3.3);
		Point point = new Point(1.0, 1.0);
		screen.addShape(Shape.shapeType.RECTANGLE, point, parameters);

		parameters = new ArrayList<Double>();
		parameters.add(4.0);
		point = new Point(3.0, 2.1);
		screen.addShape(Shape.shapeType.CIRCLE, point, parameters);

		parameters = new ArrayList<Double>();
		parameters.add(2.0);
		point = new Point(1.0, 0.5);
		screen.addShape(Shape.shapeType.SQUARE, point, parameters);

		List<Shape> sortedList = screen.sortListOfShape("originDistance");
		double[] actualOutput = new double[sortedList.size()];
		for (int i = 0; i < sortedList.size(); i++) {
			actualOutput[i] = sortedList.get(i).getOriginDistance();
		}
		double[] expectedOutput = { 1.11, 1.41, 3.26 };
		assertArrayEquals(expectedOutput, actualOutput, 1.50 );
	}

}
