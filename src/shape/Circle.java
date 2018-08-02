package shape;

import java.util.Date;

import screen.Point;

class Circle implements Shape{
	private double radius;
	private Point origin;
    private Point centre;
    private long timeStamp;
    Date currentDate=new Date();
    
    /**
     * constructor
     * @param originX and originY contains coordinates of point on the circle that lies on the line connecting the center to the origin of screen.
     * @param radius is the radius of circle
     */
	Circle(double originX, double originY,double radius){
		this.origin=new Point(originX,originY);
		this.radius=radius;
		timeStamp=currentDate.getTime();
		findCentre();
	}
	
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	 /**
     * Check whether given point is enclosed within circle or not
     * @return true if point is enclosed within circle otherwise false
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        boolean isEnclosed=false;
        float centerToPointDistance=(float)Math.sqrt((centre.getX()-point.getX()) * (centre.getX()-point.getX())+ (centre.getX()-point.getX()));
        if(centerToPointDistance<=radius)
        {
            isEnclosed=true;
        }
        return isEnclosed;
    }
    
    /**
     * Calculate distance between origin of circle to the origin of screen
     * @return distance
     */
    @Override
    public double getOriginDistance()
    {
        double distance=Math.sqrt(origin.getY() * origin.getY() + (origin.getY() * origin.getY()));
        return distance;
    }
    
  
    public shapeType getShapeType()
    {
        return shapeType.CIRCLE;
    }
    
    /**
     * private helper method to get center of circle using section formula
     */
	private void findCentre()
    {
     double distance;   //distance of centre of circle from screen origin
     distance=(radius + Math.sqrt(origin.getX() * origin.getX() + origin.getY() * origin.getY()));
     double x_Coordinate = (distance*origin.getX())/(distance-radius);
     double y_Coordinate = (distance*origin.getY())/(distance-radius);
     centre=new Point(x_Coordinate, y_Coordinate);
    }



	@Override
	public long getTimeStamp() {
		 return timeStamp;
	}


}
