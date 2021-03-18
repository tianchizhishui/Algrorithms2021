import java.util.*;

public class RemoveCoveredIntevals {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0;
        int left = -1, right = -1;
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        for (int[] cur : intervals) {
            // with no overlap
            if (cur[0] > left && cur[1] > right) {
                left = cur[0];
                res++;
            }
            // with overlap, then not count to res
            right = Math.max(right, cur[1]);
        }
        return res;
    }
}
