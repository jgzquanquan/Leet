/**
 * @author jgz
 * @Date 2020-03-24 16:21
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left+1 : right+1;
    }

}
