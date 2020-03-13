import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-13 13:42
 */
public class PathSum {
    private List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root == null) return res;
        pathSum(new ArrayList<Integer>(), root, sum, 0);
        return res;
    }

    private void pathSum( List<Integer> path, TreeNode root, int sum, int cur) {
        cur += root.val;
        path.add(root.val);
        if (cur == sum && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }

        if (root.left != null){
            pathSum(path, root.left, sum, cur);
            path.remove(path.size()-1);
        }

        if (root.right != null){
            pathSum(path, root.right, sum, cur);
            path.remove(path.size()-1);
        }
    }


}
