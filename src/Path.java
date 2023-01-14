import java.io.File;
import java.io.IOException;
import java.util.*;

public class Path 
{
	private Point[] points;
	private double  minX, minY; //min X and Y values, for setting canvas scale
	private double  maxX, maxY; //maxes
	private double distance;
	private final double padding = 10;
	
	/** construct a path from a given file */
	public Path(String fileName) throws IOException
	{
		Scanner scan = new Scanner(new File(fileName));
		scan.nextDouble(); // remove the title of the text document

		// for points
		ArrayList<Point> pointArrayList = new ArrayList<Point>();
		while (scan.hasNextDouble()) pointArrayList.add(new Point(scan.nextDouble(), scan.nextDouble()));
		points = new Point[pointArrayList.size()];
		for (int i = 0; i < pointArrayList.size(); i++) points[i] = pointArrayList.get(i);

		minX = getLeftmostPoint().getX();
		minY = getBottomPoint().getY();
		maxX = getRightmostPoint().getX();
		maxY = getTopPoint().getY();

		distance = getDistance();
	}
	
	public double getMinX() {
		return minX;
	}

	public void setMinX(double minX) {
		this.minX = minX;
	}

	public double getMinY() {
		return minY;
	}

	public void setMinY(double minY) {
		this.minY = minY;
	}

	public double getMaxX() {
		return maxX;
	}

	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	public double getMaxY() {
		return maxY;
	}

	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}

	public Point getPoint(int index) {
		return points[index];
	}

	public Point[] getPoints() {
		return points;
	}

	public void setPoints(Point[] points) {
		this.points = points;
	}

	/** returns the distance traveled going point to point, in order given in file */
	public double getDistance()
	{
		// client fetching
		if (distance != 0.0) return distance;

		// for constructor
		double distanceSum = 0.0;
		for (int i = 0; i < points.length - 1; i++) distanceSum += points[i].getDistance(points[i + 1]);
		return distanceSum;
	}

	public int getNumPoints() {
		return points.length;
	}

	private Point getTopPoint() {
		Point topPoint = getPoint(0);
		for (Point eachPoint: points) if (topPoint.getY() < eachPoint.getY()) topPoint = eachPoint;
		return topPoint;
	}

	private Point getBottomPoint() {
		Point bottomPoint = getPoint(0);
		for (Point eachPoint: points) if (bottomPoint.getY() > eachPoint.getY()) bottomPoint = eachPoint;
		return bottomPoint;
	}

	private Point getLeftmostPoint() {
		Point leftmostPoint = getPoint(0);
		for (Point eachPoint: points) if (leftmostPoint.getX() > eachPoint.getX()) leftmostPoint = eachPoint;
		return leftmostPoint;
	}

	private Point getRightmostPoint() {
		Point rightmostPoint = getPoint(0);
		for (Point eachPoint: points) if (rightmostPoint.getX() < eachPoint.getX()) rightmostPoint = eachPoint;
		return rightmostPoint;
	}

	@Override
	public String toString() {
		return "Path{" +
				"points=" + Arrays.toString(points) +
				", minX=" + minX +
				", minY=" + minY +
				", maxX=" + maxX +
				", maxY=" + maxY +
				", distance=" + distance +
				'}';
	}
}
