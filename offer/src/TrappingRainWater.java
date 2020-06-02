import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-04-04 10:08
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<height.length; i++){
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                int h = height[stack.pop()];
                if (stack.isEmpty())
                    break;
                int dis = i - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[i]);
                ans += (min - h) * dis;
            }
            stack.push(i);
        }
        return ans;
    }
}
