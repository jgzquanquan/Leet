import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-02-27 20:47
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val >= maxValue || root.val<=minValue) return false;
        return isValidBST(root.right,root.val,maxValue)  && isValidBST(root.left,minValue,root.val);
    }

    public static boolean isValidBST1(TreeNode root) {
        if(root == null) return true;
        double min = - Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(cur.val <= min) return false;
                System.out.println(cur.val);
                min = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        isValidBST1(root);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

