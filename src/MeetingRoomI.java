import java.util.*;

public class MeetingRoomI {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length <= 1) {
            return true;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                if (i1[0] == i2[0]) {
                    return 0;
                }
                return i1[0] < i2[0] ? -1 : 1;
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}
