/**
 * 8
 * @author jgz
 * @Date 2020-02-28 16:18
 */
public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {   if (pNode == null) return null;
        //右子树不为空则找出其最左节点
        if (pNode.right!=null){
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }else {
            //右子树为空则找以当前节点所在的树为左子树的节点
            while (pNode.next != null){
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
