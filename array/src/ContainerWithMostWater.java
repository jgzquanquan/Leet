/**
 * 11
 * @author jgz
 * @Date 2020-02-13 21:33
 */

//枚举左右边界
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        for (int i=0;i<height.length;i++){
            for (int j=height.length-1;j>i;j--){
                int tmp = (j-i)*Math.min(height[i],height[j]);
                area = Math.max(tmp,area);
            }
        }
        return area;
    }

    /*双指针法*/
    public int maxArea1(int[] height) {
        int area = 0;
        for (int i=0,j=height.length-1;i<j;){
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            area = Math.max(area,(j-i+1)*minHeight);
        }
        return area;
    }
}
