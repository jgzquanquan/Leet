/**
 * @author jgz
 * @Date 2020-03-13 11:48
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return verifyPostorder(postorder, 0, postorder.length-1);
    }

    public boolean verifyPostorder(int[] postorder, int left, int right){
        if (left >= right) return true;
        int root = postorder[right];
        int i=0;
        for (; i<right; i++){
            if (postorder[i] > root) break;;
        }

        int j=i;
        for (; j<right; j++){
            if (postorder[j] < root)
                return false;
        }

        return verifyPostorder(postorder, left, i-1) && verifyPostorder(postorder, i, right-1);
    }
}
