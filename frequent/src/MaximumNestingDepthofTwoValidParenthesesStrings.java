import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-04-01 10:22
 */
public class MaximumNestingDepthofTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        int[] depth = new int[seq.length()];
        int d = 0;
        int i = 0;
        for (char c : seq.toCharArray()){
            if (c == 'c'){
                d++;
                depth[i++] = d % 2;
            }else {
                depth[i++] = d % 2;
                d--;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        new MaximumNestingDepthofTwoValidParenthesesStrings().maxDepthAfterSplit("(()())");

    }
}
