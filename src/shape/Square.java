package shape;

import java.util.Date;

import screen.Point;

class Square implements Shape{
	private double length;
	private Point origin;
	private long timeStamp;
	Date currentDate=new Date();

	Square(double originX, double originY, double length){
		this.origin=new Point(originX, originY);
		this.length=length;	
		timeStamp=currentDate.getTime();
	}

	@Override
	public double getArea() {
		return length * length;
	}

	@Override
	public double getPerimeter() {
		return 2 * length;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		boolean bound=false;
		if((point.getX()>origin.getX() && point.getX()<origin.getX()+length) && (point.getY()>origin.getY() && point.getY()<origin.getY()+length)) {
			bound=true;
		}
		return bound;
	}

	@Override
	 public long getTimeStamp(){
        return timeStamp;
	}

	@Override
	public shapeType getShapeType() {
		return shapeType.SQUARE;
	}
	
	@Override
	public double getOriginDistance() {
		double distance=Math.sqrt(origin.getY() * origin.getY() + (origin.getY() * origin.getY()));
        return distance;
	}

}
