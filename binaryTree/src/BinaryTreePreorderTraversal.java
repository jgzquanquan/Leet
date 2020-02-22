import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-02-21 12:39
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root!=null){
            res.add(root.val);
            if (root.left!=null) helper(root.left,res);
            if (root.right!=null) helper(root.right,res);
        }
    }

    //迭代使用栈
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }
}
