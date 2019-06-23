
public class Circle {
	private Point center;
	private double radius;
	
	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public boolean enclose(Point p) {
		return p.distance(center) <= radius;
	}
	
	public Point getCenter() {
		return this.center;
	}
	
	public double radius() {
		return this.radius;
	}
}