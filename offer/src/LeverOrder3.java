import java.util.*;

/**
 * @author jgz
 * @Date 2020-03-12 12:52
 */
public class LeverOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int lever = 1;
        while (!queue.isEmpty()){
            int size  = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++){
                TreeNode cur = queue.remove();
                list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            if ((lever & 1) == 0)
                Collections.reverse(list);
            res.add(list);
            lever++;
        }
        return res;
    }
}
