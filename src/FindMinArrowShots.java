import java.util.*;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0 || points[0].length == 0) {
            return 0;
        }

        Arrays.sort(points, (i1, i2) -> Integer.compare(i1[1], i2[1]));

        int arrowPos = points[0][1];
        int minArrow = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= arrowPos) {
                continue;
            }
            minArrow++;
            arrowPos = points[i][1];
        }
        return minArrow;
    }
}
