import java.awt.Point;
import java.util.Scanner;

public class Triangle {

	private final class Edge {
		private Point p1,p2;
		private double val;
		public Edge(Point point1 , Point point2) {
			p1 = point1;
			p2 = point2;
			val = p1.distance(p2);
		}
		public void changeEdge(Point point1 , Point point2) {
			p1 = point1;
			p2 = point2;
			val = p1.distance(p2);
		}
		public double getValue() {
			return val;
		}
		
	}
	private Point[] points;
	private Edge[] edges;
	static final int EDGE_OR_POINT_NUMBER = 3;
	public Triangle(int[] x , int[] y) {
		points = new Point[EDGE_OR_POINT_NUMBER];
		edges = new Edge[EDGE_OR_POINT_NUMBER];
		for (int i = 0 ; i < EDGE_OR_POINT_NUMBER ; i ++) {
			points[i] = new Point(x[i] , y[i]);
			/*points[i].x = x[i];
			points[i].y = y[i];*/
		}
		setEdges();
	}
	private void setEdges() {
		int edgeNO = 0;
		for (int i = 0 ; i < EDGE_OR_POINT_NUMBER ; i ++) {
			for (int j = i + 1 ; j < EDGE_OR_POINT_NUMBER ; j ++) {
				edges[edgeNO] = new Edge(points[i] , points[j]);
				edgeNO++;
			}
		}
	}
	public double getSquare() {
		double p = 0 , area = 0;
		for (int i = 0 ; i < EDGE_OR_POINT_NUMBER ; i ++) {
			p += edges[i].getValue() / 2;
		}
		area = p;
		for (int i = 0 ; i < EDGE_OR_POINT_NUMBER ; i ++) {
			area *= p - edges[i].getValue();
		}
		return Math.sqrt(area);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] x,y;
		x = new int[Triangle.EDGE_OR_POINT_NUMBER];
		y = new int[Triangle.EDGE_OR_POINT_NUMBER];
		for (int i  = 0 ; i < Triangle.EDGE_OR_POINT_NUMBER ; i++) {
			System.out.println("Please input x" + i + " y" + i);
			Scanner in = new Scanner(System.in);
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			System.out.println("x" + i + ": " + x[i] + " y" + i + ": " + y[i]);
		}
		Triangle t = new Triangle(x, y);
		System.out.println("The square of this Triangle is" + t.getSquare());
		return;
	}

}
