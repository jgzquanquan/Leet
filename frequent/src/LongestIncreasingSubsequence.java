import java.util.Arrays;

/**
 * @author jgz
 * @Date 2020-03-14 21:17
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i=1; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int lengthOfLIS1(int[] nums) {
        int[] sortedArray = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int start = 0;
            int end = size; // 1 element past end of our sortedArray
            while (start != end) {
                int mid = (start + end) / 2;
                if (sortedArray[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            sortedArray[start] = num;
            if (start == size) {
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        new LongestIncreasingSubsequence().lengthOfLIS(nums);
    }
}
