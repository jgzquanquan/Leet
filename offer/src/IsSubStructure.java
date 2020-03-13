import java.util.HashMap;

/**
 * @author jgz
 * @Date 2020-03-10 17:22
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
}

public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean res = false;
        if (A != null && B!=null){
            if (A.val == B.val)
                res = HasSubStructure(A, B);
            if (!res)
                res = isSubStructure(A.left, B);
            if (!res)
                res = isSubStructure(A.right, B);
        }
        return res;
    }

    private boolean HasSubStructure(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        if (a.val != b.val)
            return false;
        return HasSubStructure(a.left, b.left) && HasSubStructure(a.right,b.right);
    }
}
