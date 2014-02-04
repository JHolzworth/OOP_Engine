package letters;
import java.awt.Point;


public class LetterPoint {
	
	public static Point[] getV(){
		Point[] points = new Point[3];
		points[0] = new Point(-5,-5);
		points[1] = new Point(0,5);
		points[2] = new Point(5,-5);
		return points;
	}
	
	public static Point[] getO(){
		Point[] points = new Point[17];
		points[0] = new Point(1,-5);
		points[1] = new Point(2,-4);
		points[2] = new Point(3,-3);
		points[3] = new Point(4,-2);
		points[4] = new Point(4,1);
		points[5] = new Point(3,3);
		points[6] = new Point(2,4);
		points[7] = new Point(1,5);
		
		points[8] = new Point(-1,5);
		points[9] = new Point(-2,4);
		points[10] = new Point(-3,3);
		points[11] = new Point(-4,1);
		points[12] = new Point(-4,-2);
		points[13] = new Point(-3,-3);
		points[14] = new Point(-2,-4);
		points[15] = new Point(-1,-5);
		points[16] = new Point(1,-5);
		return points;
	}

	
	public static Point[] getL(){
		Point[] points = new Point[3];
		points[0] = new Point(-5,-5);
		points[1] = new Point(-5,5);
		points[2] = new Point(0,5);
		return points;
	}

	
	public static Point[] getECase(){
		Point[] points = new Point[4];
		points[0] = new Point(2,-5);
		points[1] = new Point(-5,-5);
		points[2] = new Point(-5,5);
		points[3] = new Point(2,5);
		return points;
	}
	
	public static Point[] getEInner(){
		Point[] points = new Point[2];
		points[0] = new Point(-5,0);
		points[1] = new Point(0,0);
		return points;
	}

	public static Point[] getY(){
		Point[] points = new Point[5];
		points[0] = new Point(-5,-5);
		points[1] = new Point(0,0);
		points[2] = new Point(0,5);
		points[3] = new Point(0,0);
		points[4] = new Point(5,-5);
		return points;
	}
	
}
