public class Solution {
    public void sortColors(int[] nums) {
        int cur = 0;
        int p0 = 0;
        int p2 = nums.length -1;
        while (cur <= p2){
            if (nums[cur] == 0){
                swap(nums,cur,p0);
                cur++;
                p0++;
            }else if (nums[cur] == 1){
                cur++;
            }else if (nums[cur] == 2){
                swap(nums,cur,p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        new Solution().sortColors(nums);
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }
}
