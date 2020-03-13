import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jgz
 * @Date 2020-03-12 12:21
 */
public class LevelOrder {

    public int[] levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            if (cur != null){
                res.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
