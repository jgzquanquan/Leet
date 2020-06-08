import java.util.HashSet;
import java.util.Set;

/**
 * @author jgz
 * @Date 2020-06-06 09:01
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int maxLen = 0;
        for (int num : nums){
            if (!set.contains(num-1)){
                int cur = num;
                int curLen = 1;
                while (set.contains(cur+1)){
                    cur = cur + 1;
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        new LongestConsecutiveSequence().longestConsecutive(new int[]{3,1,3});
    }
}
