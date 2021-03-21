import java.util.*;

public class NonOverlapInterval {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        int res = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                res++;
            }
        }
        return intervals.length - res;
    }
}
