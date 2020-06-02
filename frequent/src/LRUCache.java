import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-05-25 10:14
 */


public class LRUCache {

    class DLinkedNode {

        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,DLinkedNode> map = new LinkedHashMap<>();
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode res = map.get(key);
        if (res == null){
            return -1;
        }
        moveToHead(res);
        return res.value;
    }

    public void put(int key, int value) {
        DLinkedNode res = map.get(key);
        if (res == null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            if (map.size() > capacity){
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
            }
        } else {
            res.value = value;
            moveToHead(res);
        }
    }


    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node){
        remove(node);
        addToHead(node);
    }

    private DLinkedNode removeTail(){
        DLinkedNode node = tail.prev;
        remove(node);
        return node;
    }
}
