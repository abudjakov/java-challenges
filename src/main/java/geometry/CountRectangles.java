package geometry;


import java.util.HashMap;
import java.util.Map;

/**
 Input: array of Points

 Found number of rectangles which these points can form, sides of rectangles should be parallel to axis X and Y

(0, 4)      (3, 4)      (6, 4)
 * -------- * --------- *
 |          |           |   \
 |          |           |     \
(0, 2)      (3, 2)      (6, 2)  (8, 2
 * -------- * --------- * ------ *
 |          |           |       /
 |          |           |     /
(0, 0)      (3, 0)      (6, 0)
 * --------- * --------- *

 * */
public class CountRectangles {


    public static int count(Point[] points) {
        Map<LineY, Integer> map = new HashMap<>();

        int count = 0;
        for (Point p1 : points) {
            for (Point p2: points) {
                if (p1.x == p2.x && p1.y > p2.y) {
                    LineY line = new LineY(p1.y, p2.y);
                    count += map.compute(line, (k, v) -> v == null ? 0 : v + 1);
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(0,0),
                new Point(0,2),
                new Point(0,4),
                new Point(3,0),
                new Point(3,2),
                new Point(3,4),
//                new Point(6,0),
//                new Point(6,2),
//                new Point(6,4),
//                new Point(8,2),
        };

        System.out.println(count(points)); // 9

        points = new Point[]{
                new Point(0,0),
                new Point(0,2),
                new Point(3,0),
                new Point(3,2),
                new Point(6,0),
                new Point(6,2),
                new Point(9,0),
                new Point(9,2),
                new Point(12,0),
                new Point(12,2),
        };

        System.out.println(count(points)); // 10
    }

}
