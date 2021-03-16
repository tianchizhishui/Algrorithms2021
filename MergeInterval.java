import java.util.*;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int[] curInterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(curInterval);
        for (int i = 0; i < intervals.length; i++) {
            if (curInterval[1] >= intervals[i][0]) {
                curInterval[1] = Math.max(curInterval[1], intervals[i][1]);
            } else {
                curInterval = intervals[i];
                res.add(curInterval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
