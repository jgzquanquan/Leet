import com.sun.org.apache.xml.internal.utils.res.IntArrayWrapper;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-02-21 20:35
 */
public class NaryTreePreorderTraversal {
    private ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root!=null){
            res.add(root.val);
            for(Node node:root.children){
                preorder(node);
            }
        }
        return res;
    }

    public List<Integer> preorder1(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            for (int i=root.children.size()-1;i>=0;i--){
                stack.push(root.children.get(i));
            }
        }
        return list;
    }
}
