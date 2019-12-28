import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2019-12-11 21:04
 * 205
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        for (int i=0;i<s.length();i++){
            if (s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))) return false;
        }

        return true;
    }
}
