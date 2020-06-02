import java.util.*;

/**
 * @author jgz
 * @Date 2020-04-22 09:39
 */
public class BinaryTreeRightSideView {
//    广度优先遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.remove();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
                if (i == size - 1){
                    res.add(cur.val);
                }
            }
        }
        return res;
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int depth) {
        if (root == null){
            return;
        }

        if (depth == res.size()){
            res.add(root.val);
        }
        dfs(root.right, res, depth+1);
        dfs(root.left, res, depth+1);
    }
}
