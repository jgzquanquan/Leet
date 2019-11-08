//235
public class LowestCommonAncestorOfaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root==p || root==q){
            return root;
        }
        if (root.val>p.val && root.val>q.val){
            return this.lowestCommonAncestor(root.left,p,q);
        }
        if (root.val<p.val && root.val<q.val){
            return this.lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root==p || root==q){
            return root;
        }
        while (root!=null){
            if (root.val>p.val && root.val>q.val){
                root = root.left;
            }else if (root.val<p.val && root.val<q.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return null;
    }
}
