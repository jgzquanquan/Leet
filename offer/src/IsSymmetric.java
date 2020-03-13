import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jgz
 * @Date 2020-03-11 10:39
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null || t1.val != t2.val) return false;
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);

    }

    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        q1.add(root);
        while (!q1.isEmpty()){
            TreeNode t1 = q1.remove();
            TreeNode t2 = q1.remove();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null || t1.val != t2.val) return false;
            q1.add(t1.left);
            q1.add(t2.right);
            q1.add(t1.right);
            q1.add(t2.left);
        }
        return true;
    }
}
