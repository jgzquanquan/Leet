import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-24 16:02
 */
public class KthLargest {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(list.size()-k);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root==null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
