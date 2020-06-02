package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-31 12:33
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(res, sb, 0, 0, n);
        return res;
    }

    private void backTrack(List<String> res, StringBuilder sb, int l, int r, int n) {
        if (sb.length() == 2*n){
            res.add(sb.toString());
        }

        if (l < n){
            sb.append('(');
            backTrack(res, sb, l+1, r, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if (r < l){
            sb.append(')');
            backTrack(res, sb, l, r+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
