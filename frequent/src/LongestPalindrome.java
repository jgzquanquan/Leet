/**
 * @author jgz
 * @Date 2020-03-19 09:15
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] count = new int[52];
        for (char c : s.toCharArray()){
            if (c >= 'a'){
                count[c - 'a']++;
            }else {
                count[c - 'A' + 26]++;
            }
        }

        int ans = 0;
        for (int num : count){
            ans += num/2*2;
        }
        return ans < s.length() ? ans+1 : ans;
    }
}
