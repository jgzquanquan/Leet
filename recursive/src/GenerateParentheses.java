import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-02-27 20:23
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0,0,n,"",res);
        return res;
    }

    private void generate(int left, int right, int n, String s, List<String> res) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n) generate(left+1,right,n,s+"(",res);
        if (right < left) generate(left,right+1,n,s+")",res);
    }

}
