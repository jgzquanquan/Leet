package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-31 09:45
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for (int end = 1; end < s.length(); end++){
            for (int start = 0; start < end; start++){
                if (dp[start] && wordDict.contains(s.substring(start, end))){
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        new WordBreak().wordBreak(s, wordDict);
     }
}
