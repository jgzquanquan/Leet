import sun.nio.cs.ext.MacHebrew;

/**
 * @author jgz
 * @Date 2020-04-18 10:49
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max  = 0;
        while (left < right){
            int area = 0;
            if (height[left] > height[right]){
                area = (right - left ) * height[right];
                right--;
            }else {
                area = (right - left) * height[left];
                left++;
            }
            max = Math.max(max, area);
        }
        return max;
    }
}
