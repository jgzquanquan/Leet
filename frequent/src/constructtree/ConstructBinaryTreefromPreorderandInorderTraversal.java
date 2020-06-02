package constructtree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jgz
 * @Date 2020-05-22 09:47
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen){
            return null;
        }
        //构建中序遍历的索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inLen; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen-1, map, 0, inLen-1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight){
            return null;
        }
        //根节点的值
        int rootVal = preorder[preLeft];
        // 构建根节点
        TreeNode root = new TreeNode(rootVal);
        //
        int pIndex = map.get(rootVal);
        //
        root.left = buildTree(preorder, preLeft+1, pIndex-inLeft+preLeft, map, inLeft, pIndex - 1);
        root.right = buildTree(preorder, pIndex-inLeft+preLeft+1, preRight, map, pIndex+1, inRight);
        return root;
    }
}
