package shape;

import java.util.Date;

import screen.Point;

/*Assume right-angled triangle
 */
public class Triangle implements Shape {
	private double base;
	private Point origin;
	private double height;
	private long timeStamp;
	Date currentDate=new Date();

	Triangle(double originX, double originY, double base, double height) {
		this.origin = new Point(originX, originY);
		this.base = base;
		this.height = height;
		timeStamp=currentDate.getTime();
	}

	@Override
	public double getArea() {
		return (0.5 * base * height);
	}

	@Override
	public double getPerimeter() {
		 return (base + height + Math.sqrt(base * base + height * height));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		Point firstVertex = getVertex1();
		Point secondVertex = getVertex2();
		if (getArea() == (getAreaWithVertices(point, origin, firstVertex)
				+ getAreaWithVertices(point, origin, secondVertex)
				+ getAreaWithVertices(point, firstVertex, secondVertex))) {
			return true;
		}
		return false;
	}

	private Point getVertex1(){
	    return new Point(origin.getX(), origin.getY() + height);   
	    }

	private Point getVertex2() {
		return new Point(origin.getX() + base, origin.getY());
	}

	double getAreaWithVertices(Point vertex1, Point vertex2, Point vertex3) {
		double area;
		area = Math.abs((vertex1.getX() * (vertex2.getY() - vertex3.getY()) + vertex2.getX() * (vertex3.getX() - vertex1.getY()) + vertex3.getX() * (vertex1.getY()) - vertex2.getY()) / 2);
		return area;
	}

	@Override
	 public long getTimeStamp(){
        return timeStamp;
    }

	@Override
	public shapeType getShapeType() {
		return shapeType.TRIANGLE;
	}
	
	@Override
	public double getOriginDistance() {
		double distance=Math.sqrt(origin.getY() * origin.getY() + (origin.getY() * origin.getY()));
        return distance;
	}
}
