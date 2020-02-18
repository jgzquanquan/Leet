import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-02-17 12:41
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i=0;i<height.length;i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int h = height[stack.pop()];
                if (stack.isEmpty())break;
                int dis = i - stack.peek() - 1;
                int min = Math.min(height[stack.peek()],height[i]);
                sum += (min-h)*dis;
            }
            stack.push(i);
        }
        return sum;
    }
}
