package dp;

/**
 * 5 最长回文子串
 * @author jgz
 * @Date 2020-05-21 08:55
 */
public class LongestPalindromicSubstring {

    //  暴力解法 O(n^3)
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        int maxlen = 1;
        int begin = 0;
        for (int i = begin; i < len-1; i++){
            for (int j = i+1; j<len; j++){
                if (j - i + 1 > maxlen && valid(chars, i, j)){
                    begin = i;
                    maxlen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin+maxlen);
    }
    // 判断是否是回文串的方法，采用双指针法
    public Boolean valid(char[] chars, int left ,int right){
        while (left < right){
            if (chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 动态规划解法
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        int maxlen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int j=1; j<len;j++){
            for (int i = 0; i < j; i++){
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                } else if (j - i < 3){
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] &&  j - i + 1 > maxlen){
                    begin = i;
                    maxlen = j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
    // 中心扩散法
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++){
            int len1 = expand(chars, i, i);
            int len2 = expand(chars, i, i+1);
            int maxlen = Math.max(len1, len2);
            if (maxlen > end - start + 1){
                start = i - (maxlen - 1) / 2;
                end = i + maxlen / 2;
            }
        }
        return s.substring(start,end+1);
    }

    private int expand(char[] chars, int l, int r) {
        while (l >=0 && r<chars.length && chars[l] == chars[r]){
            l--;
            r++;
        }
        return r-l-1;
    }

    public static void main(String[] args) {
        new LongestPalindromicSubstring().longestPalindrome2("babad");
    }

}
