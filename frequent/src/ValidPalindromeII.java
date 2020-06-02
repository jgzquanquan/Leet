/**
 * @author jgz
 * @Date 2020-05-19 09:34
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high){
            if (s.charAt(low) == s.charAt(high)){
                low++;
                high--;
            }else {
                boolean flag1 = true, flag2 = true;

                for (int i = low + 1, j = high; i < j; i++, j--){
                    if (s.charAt(i) != s.charAt(j)){
                        flag1 = false;
                        break;
                    }
                }

                for (int i = low, j = high - 1; i < j; i++, j--){
                    if (s.charAt(i) != s.charAt(j)){
                        flag2 = false;
                        break;
                    }
                }

                return flag1 || flag2;
            }
        }
        return true;
    }
}
