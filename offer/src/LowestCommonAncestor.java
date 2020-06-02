/**
 * @author jgz
 * @Date 2020-03-31 13:24
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else {
            return root;
        }
    }
}
