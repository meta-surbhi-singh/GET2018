package shape;

import screen.Point;

public interface Shape {
static enum shapeType{ SQUARE, RECTANGLE, CIRCLE, TRIANGLE }
public double getArea();
public double getPerimeter();
public Point getOrigin();
public boolean isPointEnclosed(Point point);
public long getTimeStamp();
public shapeType getShapeType();
public double getOriginDistance();
}
