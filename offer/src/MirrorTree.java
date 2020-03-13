/**
 * @author jgz
 * @Date 2020-03-10 17:44
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
    }
}
