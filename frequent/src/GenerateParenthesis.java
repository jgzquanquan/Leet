import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-04-09 10:13
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backTrack(List<String> res, StringBuilder sb, int left, int right, int max) {
        if (sb.length() == max * 2){
            res.add(sb.toString());
            return;
        }
        
        if (left < max){
            sb.append('(');
            backTrack(res, sb, left+1, right, max);
            sb.deleteCharAt(sb.length()-1);
        }

        if (right < left){
            sb.append(')');
            backTrack(res, sb, left, right+1, max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
