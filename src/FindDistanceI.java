class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class FindDistanceI {
    private int res;

    public int findDistance(TreeNode root, int p, int q) {
        if (p == q) return 0;
        res = -1;
        helper(root, p, q);
        return res;
    }

    private int helper(TreeNode root, int p, int q) {
        if (root == null) return -1;

        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);

        if (root.val == p || root.val == q) {
            if (left < 0 && right < 0) {
                return 0;
            }

            res = 1 + (left >= 0 ? left : right);
            return -1;
        }

        if (left >= 0 && right >= 0) {
            res = left + right + 2;
            return -1;
        }

        if (left >= 0) {
            return left + 1;
        }

        if (right >= 0) {
            return right + 1;
        }

        return -1;
    }
}
