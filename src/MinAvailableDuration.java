import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAvailableDuration {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(slots1, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        Arrays.sort(slots2, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int i = 0;
        int j = 0;

        int n1 = slots1.length;
        int n2 = slots2.length;

        while (i < n1 && j < n2) {
            int curItrStart = Math.max(slots1[i][0], slots2[j][0]);
            int curItrEnd = Math.min(slots1[i][1], slots2[j][1]);

            if (curItrEnd - curItrStart >= duration) {
                return Arrays.asList(curItrStart, curItrStart + duration);
            } else if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return new ArrayList<>();
    }
}
