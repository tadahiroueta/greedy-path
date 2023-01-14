import java.io.*;
import java.util.*;

public class GreedyPath extends Path {
    private Point[] greedyPoints;
    private double greedyDistance;

    /**
     * construct a path from a given file
     *
     * @param fileName
     */
    public GreedyPath(String fileName) throws IOException {
        super(fileName);

        // initialling greedyPoints
        ArrayList<Point> greedyPointsList = new ArrayList<Point>();
        greedyPointsList.add(super.getPoint(0));
        super.getPoint(0).setVisited(true);
        for (int i = 0; i < getNumPoints() - 1; i++) greedyPointsList.add(getClosestPoint(
                greedyPointsList.get(i)));
        greedyPoints = new Point[greedyPointsList.size()];
        for (int i = 0; i < greedyPointsList.size(); i++) greedyPoints[i] = greedyPointsList.get(i);

        greedyDistance = getDistance();
    }

    private Point getClosestPoint(Point startingPoint) {
        Point closestPoint = new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        for (Point eachPoint: getPoints()) if (!eachPoint.isVisited() &&
                startingPoint.getDistance(eachPoint) < startingPoint.getDistance(closestPoint)) {
            closestPoint = eachPoint;
        }
        closestPoint.setVisited(true);
        return closestPoint;
    }

    @Override
    public double getDistance() {
        // for reverse override: "underride"
        if (greedyPoints == null) return super.getDistance();

        // client fetching
        if (greedyDistance != 0.0) return greedyDistance;

        // for constructor
        double distanceSum = 0.0;
        for (int i = 0; i < getNumPoints() - 1; i++) distanceSum += greedyPoints[i].getDistance(
                greedyPoints[i + 1]);
        return distanceSum;
    }

    @Override
    public Point getPoint(int index) {
        // underride
        if (greedyPoints == null) return super.getPoint(index);
        return greedyPoints[index];
    }

    @Override
    public String toString() {
        return "GreedyPath{" +
                "greedyPoints=" + Arrays.toString(greedyPoints) +
                '}';
    }
}
