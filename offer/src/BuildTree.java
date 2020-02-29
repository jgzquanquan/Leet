import java.util.HashMap;
import java.util.Map;

/**
 * 7
 * @author jgz
 * @Date 2020-02-28 10:49
 */
public class BuildTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        Map<Integer,Integer> inMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inMap){
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) return root;
        else {
            int rootIndex = inMap.get(root.val);
            int leftLength = rootIndex - inStart;
            int rightLength = inEnd - rootIndex;
            root.left = buildTree(preorder,preStart+1, preStart+leftLength, inorder, inStart, rootIndex-1, inMap);
            root.right = buildTree(preorder,preEnd - rightLength + 1, preEnd, inorder, rootIndex+1 , inEnd, inMap);
            return root;
        }
    }
}
