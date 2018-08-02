package screen;

import java.util.*;
import shape.Shape;

public class Sort {
	/**
	 * static method for sorting of list of shapes on the basis of area
	 * @param shapeList contains list of shapes which is to be sorted
	 * @return returns sorted list
	 */
	
	public static List<Shape> sortArea(List<Shape> shapeList) {
		for (int index1 = 0; index1 < shapeList.size() - 1; index1++) {
			for (int index2 = 0; index2 < shapeList.size() - index1 - 1; index2++) {
				if (shapeList.get(index2).getArea() > shapeList.get(index2 + 1).getArea()) {
					shapeList.set(index2, shapeList.get(index2 + 1));
					shapeList.set(index2 + 1, shapeList.get(index2));
				}
			}
		}
		return shapeList;
	}

	/**
	 * static method for sorting of list of shapes on the basis of perimeter
	 * @param shapeList contains list of shapes which is to be sorted
	 * @return returns sorted list
	 */
	public static List<Shape> sortPerimeter(List<Shape> shapeList) {
		for (int index1 = 0; index1 < shapeList.size() - 1; index1++) {
			for (int index2 = 0; index2 < shapeList.size() - index1 - 1; index2++) {
				if (shapeList.get(index2).getPerimeter() > shapeList.get(index2 + 1).getPerimeter()) {
					shapeList.set(index2, shapeList.get(index2 + 1));
					shapeList.set(index2 + 1, shapeList.get(index2));
				}
			}
		}
		return shapeList;
	}

	/**
	 * static method for sorting of list of shapes on the basis of timestamp
	 * @param shapeList contains list of shapes which is to be sorted
	 * @return returns sorted list
	 */
	public static List<Shape> sortTimeStamp(List<Shape> shapeList) {
		for (int index1 = 0; index1 < shapeList.size() - 1; index1++) {
			for (int index2 = 0; index2 < shapeList.size() - index1 - 1; index2++) {
				if (shapeList.get(index2).getTimeStamp() >  shapeList.get(index2 + 1).getTimeStamp()) {
					shapeList.set(index2, shapeList.get(index2 + 1));
					shapeList.set(index2 + 1, shapeList.get(index2));
				}
			}
		}
		return shapeList;
	}

	/**
	 * static method for sorting of list of shapes on the basis of origin distance
	 * @param shapeList contains list of shapes which is to be sorted
	 * @return returns sorted list
	 */
	public static List<Shape> sortOriginDistance(List<Shape> shapeList) {
		for (int index1 = 0; index1 < shapeList.size() - 1; index1++) {
			for (int index2 = 0; index2 < shapeList.size() - index1 - 1; index2++) {
				if (shapeList.get(index2).getOriginDistance() > shapeList.get(index2 + 1).getOriginDistance()) {
					shapeList.set(index2, shapeList.get(index2 + 1));
					shapeList.set(index2 + 1, shapeList.get(index2));
				}
			}
		}
		return shapeList;
	}

}
