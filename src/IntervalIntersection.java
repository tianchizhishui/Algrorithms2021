import java.util.*;

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new int[][]{};
        }

        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (end >= start) {
                res.add(new int[]{start, end});
            }
            if (firstList[i][1] == end) i++;
            if (secondList[j][1] == end) j++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}
