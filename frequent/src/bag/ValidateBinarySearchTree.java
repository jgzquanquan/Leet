package bag;

import javax.swing.tree.TreeNode;

/**
 * @author jgz
 * @Date 2020-05-05 08:41
 */
public class ValidateBinarySearchTree {

    private long pre = Long.MIN_VALUE;

    //根据二叉搜索树的定义
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        // 这样子判断如果是该该root的右子树的左子树也能判断出来，这时候这个左子树的节点值是在其爷爷节点的值和其父亲节点的值之间
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    // 根据中序遍历结果是不是递增的
    //根据二叉搜索树的定义
    public boolean isValidBST1(TreeNode root) {
        if (root == null){
            return true;
        }

        if (!isValidBST1(root.left) || root.val <= pre){
            return false;
        }

        pre = root.val;

        return isValidBST1(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
