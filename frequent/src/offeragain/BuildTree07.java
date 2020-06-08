package offeragain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-06-02 12:13
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class BuildTree07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, map, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> map, int pl, int pr, int il, int ir) {
        if (pl > pr || il > ir){
            return null;
        }
        int val = preorder[pl];
        int index = map.get(val);
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder, map, pl+1, pl+1+index-il, il, index-1);
        root.right = buildTree(preorder, map,  pl+2+index-il,pr, index+1, ir);
        return root;
    }
}
