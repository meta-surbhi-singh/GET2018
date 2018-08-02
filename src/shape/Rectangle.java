package shape;

import java.util.Date;

import screen.Point;

class Rectangle implements Shape{

	private double breadth;
	private double length;
	private Point origin;
	private long timeStamp;
	Date currentDate=new Date();

	Rectangle(double originX, double originY, double length, double breadth){
		this.origin=new Point(originX,originY);
		this.length=length;
		this.breadth=breadth;
		timeStamp=currentDate.getTime();
		
	}
	@Override
	public double getArea() {
		return length*breadth;
	}

	@Override
	public double getPerimeter() {
		return 2*(length+breadth);
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		boolean bound=false;
		if((point.getX()>origin.getX() && point.getX()<origin.getX()+length) && (point.getY()>origin.getY() && point.getY()<origin.getY()+breadth)) {
			bound=true;
		}
		return bound;
	}
	
	@Override
	public long getTimeStamp() {
	     return timeStamp;
	}
	@Override
	public shapeType getShapeType() {
		return shapeType.RECTANGLE;
	}
	@Override
	public double getOriginDistance() {
		double distance=Math.sqrt(origin.getY() * origin.getY() + (origin.getY() * origin.getY()));
        return distance;
	}

}
