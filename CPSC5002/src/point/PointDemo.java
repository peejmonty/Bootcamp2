package point;

public class PointDemo {

	public static void main(String[] args) {
		point p1 = new point();
		p1.x = 1.6;
		p1.y =1.2;
		point p2 = new point();
		System.out.printf("point(x=%f, y=%f)\n",p1.x, p1.y);
	    System.out.printf("point(r=%f, theta=%f)\n",
	    		          p1.getR(), p1.getTheta());
	    System.out.printf("point(x=%f, y=%f)\n",p2.x, p2.y);

	}
	
	

}
