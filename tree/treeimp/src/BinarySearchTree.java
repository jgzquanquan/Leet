/**
 * @author jgz
 * @Date 2019-12-26 20:26
 */
public class BinarySearchTree {
    private Node tree;

    public Node find(int data){
        Node p = tree;
        while (p != null){
            if (data < p.data)
                p = p.left;
            else if (data > p.data)
                p = p.right;
            else return p;
        }
        return null;
    }

    public void insert(int data){
        if (tree == null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p!=null){
            if (data > p.data){
                if (p.right == null){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }else {
                if (p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data){
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != data){
            pp = p;
            if (data > p.data){
                p = p.right;
            }else {
                p = p.left;
            }
        }

        if (p==null)return;
//      删除有两个子节点的
        if (p.left != null && p.right != null){
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null){
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

//        删除只有一个子节点
        Node child;
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) tree = child;
        else if (pp.left == p) pp.left = child;
        else pp.right = child;

    }


    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node findMin() {
        if (tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(11);
        binarySearchTree.insert(9);
        binarySearchTree.insert(15);
    }
}
