import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-02-20 21:12
 */
public class BinaryTreeInorderTraversal {
    //递归写法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root!=null){
            if (root.left!=null) helper(root.left,res);
            res.add(root.val);
            if (root.right!= null) helper(root.right,res);
        }
    }

    //迭代使用栈
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
}
