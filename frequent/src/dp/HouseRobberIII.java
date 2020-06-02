package dp;

/**
 * @author jgz
 * @Date 2020-05-24 12:08
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robTree(TreeNode root) {
        int[] res = new int[2];
        if (root == null){
            return res;
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        res[0] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
