/**
 * @author jgz
 * @Date 2020-03-24 16:32
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    private boolean result = true;

    public boolean isBalanced1(TreeNode root){
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l-r) > 1){
            result = false;
        }
        return 1 + Math.max(l, r);
    }
}
