import java.util.*;

/*
 Shape data for ShapeClient:
 "0 0  0 1  1 1  1 0"
 "10 10  10 11  11 11  11 10"
 "0.5 0.5  0.5 -10  1.5 0"
 "0.5 0.5  0.75 0.75  0.75 0.2"
*/

public class Shape {
	private ArrayList<Point> points;
	private Circle circle;
	private String name;
	
	public Shape(String name, String input) {
		this.name = name;
		points = new ArrayList<Point>();
		Scanner s = new Scanner(input);
		while (s.hasNext()) {
			double x = s.nextDouble();
			double y = s.nextDouble();
			Point p = new Point(x, y);
			points.add(p);
		}
		s.close();
		Point center = circleCenter();
		double radius = circleRadius();
		circle = new Circle(center, radius);
	}
	
	private Point circleCenter() {
		double x = 0;
		double y = 0;
		for (Point p : points) {
			x += p.getX();
			y += p.getY();
		}
		return new Point(x/points.size(), y/points.size());
	}
	
	private double circleRadius() {
		Point centerPoint = circleCenter();
		double radius = points.get(0).distance(centerPoint);
		for (int i = 1; i < points.size(); i++) {
			Point p = points.get(i);
			double d = p.distance(centerPoint);	
			if (d < radius) {
				radius = d;
			}
		}
		return radius;
	}
	
	public Circle getCircle() {
		return this.circle;
	}
	
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean crosses(Shape other) {
		int bIndex;
		for (int i = 0; i < points.size(); i++) {
			Point a = points.get(i);
			if (i == points.size()-1) {
				bIndex = 0;
			} else {
				bIndex = i+1;
			}
			Point b = points.get(bIndex);
			Circle otherCircle = other.getCircle();
			if (lineCrosses(a, b, otherCircle)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean lineCrosses(Point a, Point b, Circle circle) {
		if ((circle.enclose(a) && !circle.enclose(b)) || ((!circle.enclose(a) && circle.enclose(b)))) {
			return true;
		} else {
			return false;
		}
	}
	
	public int encircles(Shape other) {
		Circle circleThis = this.circle;
		Circle circleThat = other.getCircle();
		if (circleThis.enclose(circleThat.getCenter())) {
			return 2;
		} else if (circleThat.enclose(circleThis.getCenter())) {
			return 1;
		} else {
			return 0;
		}
	}
	
}

