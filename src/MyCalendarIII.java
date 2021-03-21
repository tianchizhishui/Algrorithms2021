import java.util.*;

public class MyCalendarIII {
    Map<Integer, Integer> map;
    // constructor
    public MyCalendarIII() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int activeEvent = 0;
        int maxEvent = 0;
        for (int value : map.values()) {
            activeEvent += value;
            maxEvent = Math.max(maxEvent, activeEvent);
        }
        return maxEvent;
    }
}
