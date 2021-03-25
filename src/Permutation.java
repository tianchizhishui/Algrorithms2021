import java.util.*;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);
        return res;
    }

    private void helper(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int i : nums) {
                cur.add(i);
            }
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            helper(nums, index + 1, res);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
