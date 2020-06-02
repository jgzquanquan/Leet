import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-05-03 09:37
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> slideWindow = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++){
            if (slideWindow.containsKey(s.charAt(j))){
                i = Math.max(slideWindow.get(s.charAt(j))+1, i);
            }
            maxLength = Math.max(j-i+1, maxLength);
            slideWindow.put(s.charAt(j), j);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb");
    }
}
