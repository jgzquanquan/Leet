/**
 * @author jgz
 * @Date 2020-02-16 18:07
 */
public class MinStackLinkedList {
    /** initialize your data structure here. */
    private Node head;

    public MinStackLinkedList() {

    }

    public void push(int x) {
        if (head==null) head = new Node(x,x,null);
        else head = new Node(x,Math.min(x,head.min),head);

    }

    public void pop() {
        if (head!=null) head = head.next;
        else throw new RuntimeException();
    }

    public int top() {
        if (head!=null) return head.data;
        else throw new RuntimeException();
    }

    public int getMin() {
        if (head!=null) return head.min;
        else throw new RuntimeException();

    }

    private class Node{
        int data;
        int min;
        Node next;

        public Node(int data, int min, Node next) {
            this.data = data;
            this.min = min;
            this.next = next;
        }
    }
}
