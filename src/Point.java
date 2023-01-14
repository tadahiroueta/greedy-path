public class Point 
{
	private double  x, y;
	private boolean visited;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		this.visited = false; // TODO
	}

	/** get the Euclidean distance between two points */
	public double getDistance(Point other)
	{
		double xDisplacement = x - other.getX();
		double yDisplacement = y - other.getY();
		return Math.sqrt(Math.pow(xDisplacement, 2) + Math.pow(yDisplacement, 2));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "(" + x +", " + y +')';
	}

	public boolean isVisited() {
		return visited;
	}
}
