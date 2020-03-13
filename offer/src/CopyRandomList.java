import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-03-13 14:11
 */

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class CopyRandomList {
    private Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        if (map.containsKey(head)){
            return map.get(head);
        }

        Node node = new Node(head.val);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }


    public Node copyRandomList1(Node head) {
        if(head == null) return head;

        Node pre = head;
        Node cur = new Node(head.val);
        map.put(pre, cur);
        while (pre!=null){
            cur.next = getClonedNode(pre.next);
            cur.random = getClonedNode(pre.random);
            cur = cur.next;
            pre = pre.next;
        }
        return map.get(head);
    }

    private Node getClonedNode(Node next) {
        if (next == null)
            return next;
        if (!map.containsKey(next))
            map.put(next, new Node(next.val));
        return map.get(next);
    }


}
