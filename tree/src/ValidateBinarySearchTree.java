public class ValidateBinarySearchTree {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!this.isValidBST(root.left)){
            return false;
        }
        if (this.pre!=null && this.pre.val >= root.val){
            return false;
        }
        this.pre = root;
        return this.isValidBST(root.right);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

class Solution2{
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode root, Integer min,Integer max){
        if(root==null){
            return true;
        }
        if(min!=null && root.val<=min){
            return false;
        }
        if(max!=null && root.val>=max){
            return false;
        }
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}
