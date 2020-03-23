/**
 * @author jgz
 * @Date 2020-03-16 11:11
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class TreeToDoublyList {
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        inorder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        root.left = pre;
        if (pre == null)
            head = root;
        else
            pre.right = root;
        pre = root;
        inorder(root.right);
    }
}
