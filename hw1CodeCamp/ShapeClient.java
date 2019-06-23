
public class ShapeClient {
	
	public static void main(String[] args) {
		Shape a = new Shape("a", "0 0  0 1  1 1  1 0");
		Shape b = new Shape("b", "10 10  10 11  11 11  11 10");
		Shape c = new Shape("c", "0.5 0.5  0.5 -10  1.5 0");
		Shape d = new Shape("d", "0.5 0.5  0.75 0.75  0.75 0.2");
		
		Shape[] ss = new Shape[] {b, c, d};
		
		for (Shape s : ss) {
			System.out.printf("%s crosses %s:%b\n", a.getName(), s.getName(), a.crosses(s));
		}
		
		for (Shape s : ss) {
			System.out.printf("%s encircles %s:%d\n", a.getName(), s.getName(), a.encircles(s));
		}
	}

}
