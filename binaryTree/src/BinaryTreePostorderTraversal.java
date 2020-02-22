import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-02-21 16:40
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root!=null){
            if (root.left!=null) helper(root.left,res);
            if (root.right!=null) helper(root.right,res);
            res.add(root.val);
        }
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                // Reverse the process of preorder
                res.addFirst(cur.val);
                // Reverse the process of preorder
                cur = cur.right;
            }else {
                cur = stack.pop();
                // Reverse the process of preorder
                cur = cur.left;
            }
        }
        return res;
    }
}
