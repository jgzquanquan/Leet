import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jgz
 * @Date 2020-03-20 09:50
 */
public class LengthOfLongestSubstring {

//    HashSet 用作滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> slideWindow = new HashSet<>();
        for (int i=0, j=0; i<s.length() && j<s.length();){
            if (!slideWindow.contains(s.charAt(j))){
                slideWindow.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j-i);
            }else {
                slideWindow.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        Map<Character,Integer> slideWindow = new HashMap<>();
        for (int i=0, j=0; j<s.length(); j++){
            if (slideWindow.containsKey(s.charAt(j))){
                i = slideWindow.get(s.charAt(j));
            }
            maxLength = Math.max(maxLength, j-i+1);
            slideWindow.put(s.charAt(j), j+1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        int[] slideWindow = new int[128];
        for (int i=0, j=0; j<s.length(); j++){
            i = Math.max(i, slideWindow[s.charAt(j)]);
            maxLength = Math.max(maxLength, j-i+1);
            slideWindow[s.charAt(j)] = j+1;
        }
        return maxLength;
    }


}
