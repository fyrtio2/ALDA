import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Algoritmen räknar ut den kortaste sträckan mellan två punkter i en lista av punkter med X och Y kordinater.
 * Algoritmen tillåter ej identiska punkter.
 *
 *
 * @author Oscar Törnquist  - osta3589
 * @author Emil Rosell      - emro9957
 *
 *
 */

public class ClosestPair {


    private ArrayList<Point> points = new ArrayList<>();


    public void addPoint(Point p) {
        if (points.contains(p)) {
            System.out.println("Points on the same position are not allowed, point " + p.toString() + " will be ignored.");
            return;
        }
        points.add(p);
    }

    private double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2)); //Hypotenusan av Point a och Point b
    }


    public double findClosestPair(List<Point> list) {
        points.addAll(list); //kopierar list till ArrayListan points.
        return findClosestPair();
    }


    /**
     * @return -1 if list is empty or <= 1, else returns the distance
     * between the closest pairs.
     */
    public double findClosestPair() {
        if (points.size() <= 1)
            return -1;
        points.sort(new CompareX());
        return findClosestPair(0, points.size() - 1);
    }

    private double findClosestPair(int start, int end) {
        if (end - start <= 2) {
            return baseCase(start, end);
        } else {
            int middle = (start + end) / 2;
            double midX = (points.get(start).getX() + points.get(end).getX()) / 2;

            double left = findClosestPair(start, middle);
            double right = findClosestPair(middle + 1, end);
            ArrayList<Point> strip = new ArrayList<>();
            double minDelta = left < right ? left : right;

            for (Point p : points) {
                if (p.getX() > (midX - minDelta) && p.getX() < (midX + minDelta))
                    strip.add(p);
            }

            Collections.sort(strip, new CompareY());

            /*
             * Algoritm använd från s.453 i M.Weiss Datastructures and Algorithm Analysis in Java.
             */
            for (int i = 0; i < strip.size(); i++) {
                for (int j = i + 1; j < strip.size(); j++)
                    if ((strip.get(j).y - strip.get(i).y) > minDelta) {
                        break;
                    } else {
                        double tmp = getDistance(strip.get(i), strip.get(j));
                        if (tmp < minDelta) {
                            minDelta = tmp;
                        }

                    }
            }
            return minDelta;
        }

    }

    /**
     * @param start vart i ArrayListan points loopen skall börja.
     * @param end vart i ArrayListan points loopen skall sluta.
     * @return kortaste sträckan mellan noder i intervallet
     */

    public double baseCase(int start, int end) {
        double delta = Double.MAX_VALUE;
        for (int i = start; i < end + 1; i++) {
            Point tmp = points.get(i);
            for (int j = i + 1; j < end + 1; j++) {
                double newDelta = getDistance(tmp, points.get(j));
                if (newDelta < delta) {
                    delta = newDelta;
                }
            }
        }
        return delta;
    }

    public String toString() {
        String s = "";
        for (Point p : points) {
            s += "[ " + p.x + " " + p.y + " ]" + "\n";
        }
        return s;
    }


    private class CompareX implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            if (o1.x == o2.x)
                return o1.y - o2.y;
            return o1.x - o2.x;
        }
    }

    private class CompareY implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            if (o1.y == o2.y)
                return o1.x - o2.x;
            return o1.y - o2.y;
        }
    }
}
