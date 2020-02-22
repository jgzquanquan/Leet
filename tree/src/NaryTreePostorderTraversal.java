import java.util.*;

/**
 * @author jgz
 * @Date 2020-02-21 18:16
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root!=null){
            for (Node node:root.children){
                helper(node,res);
            }
            res.add(root.val);
        }
    }

    public List<Integer> postorder1(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root==null) return res;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            for (Node node:root.children){
                stack.push(node);
            }
        }
        Collections.reverse(res);
        return res;
    }

}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

