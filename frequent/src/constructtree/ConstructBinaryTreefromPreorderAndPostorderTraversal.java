package constructtree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-05-22 10:57
 */
public class ConstructBinaryTreefromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int preLen = pre.length;
        int postLen = post.length;
        if (preLen != postLen){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<postLen; i++){
            map.put(post[i], i);
        }
        return builderTree(pre, 0, preLen-1, map, 0, postLen-1);
    }

    private TreeNode builderTree(int[] pre, int preLeft, int preRight, Map<Integer, Integer> map, int postLeft, int postRight) {
        if (preLeft > preRight || postLeft > postRight){
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        if (preLeft == preRight){
            return root;
        }
        int index = map.get(pre[preLeft+1]);
        root.left = builderTree(pre, preLeft+1, preLeft + 1 + index - postLeft, map, postLeft, index);
        root.right = builderTree(pre, preLeft + 2 + index - postLeft,  preRight, map, index+1, postRight - 1);
        return root;
    }
}
