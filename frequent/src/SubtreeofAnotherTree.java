/**
 * @author jgz
 * @Date 2020-05-07 09:21
 */
public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null)
            return true;
        if (s == null)
            return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || helper(s, t);
    }

    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if(s == null) return false;
        if (helper(s,t)){
            return true;
        }else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

    }

    private boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null){
            return true;
        } else if (s == null || t == null){
            return false;
        }

        if (s.val != t.val){
            return false;
        }
        return helper(s.left, t.left) && helper(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);
        TreeNode t = new TreeNode(1);
        new SubtreeofAnotherTree().isSubtree(s, t);
    }
}
