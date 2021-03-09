import java.util.*;

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
        //corner case;
        if (intervals == null || intervals.length == 0) {
            return res;
        }

        // should maintain a start timepoint array and meeting end time point array
        // extra space O(n)
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        // transfer the 2D array to array time O (n) (matrix size (m == 2))
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        //sort both timepoints. Time O(nlog(n));
        Arrays.sort(start);
        Arrays.sort(end);

        int numOfRoom = 0;
        int numOfEndMeeting = 0;

        //go over the start point and find out the min number of how many meeting are held
        // at the same time. Time O(n)
        for (int i = 0; i <start.length; i++) {
            //when we need more rooms, more meeting is ongoing
            if (start[i] < end[numOfEndMeeting]) {
                numOfRoom++;
            } else {        // else when a meeting ends, we could use the empty meeting rooms
                numOfEndMeeting++;
            }
        }
        return numOfRoom;
    }
// Overall, this method, Time O(n) + O(nlogn); Space O(n)
}
