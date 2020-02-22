import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jgz
 * @Date 2020-02-21 23:00
 */
public class NaryTreeLevelOrderTraversal {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size()<=level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child:node.children){
            traverseNode(child,level+1);
        }
    }


    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                Node cur = queue.remove();
                level.add(cur.val);
                queue.addAll(cur.children);
            }
            res.add(level);
        }
        return res;
    }
}
