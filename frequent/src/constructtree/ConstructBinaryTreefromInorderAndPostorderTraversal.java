package constructtree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-05-22 10:27
 */
public class ConstructBinaryTreefromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int postLen = postorder.length;
        int inLen = inorder.length;
        if (postLen != inLen) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inLen; i++){
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postLen-1, map, 0, inLen-1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight, Map<Integer, Integer> map, int inLeft , int inRight) {
        if (postLeft > postRight || inLeft > inRight){
            return null;
        }
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);
        root.left = buildTree(postorder, postLeft, postLeft + pIndex - inLeft - 1, map, inLeft, pIndex - 1);
        root.right = buildTree(postorder, postLeft + pIndex - inLeft, postRight-1, map, pIndex+1, inRight);
        return root;
    }
}
