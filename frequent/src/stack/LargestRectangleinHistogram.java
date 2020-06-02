import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-05-30 09:34
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        if (heights == null || heights.length == 0){
            return maxArea;
        }
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        for (int i=0; i<heights.length; i++){
            while (indexStack.peek() != -1 && heights[indexStack.peek()] > heights[i]){
                int index = indexStack.pop();
                maxArea = Math.max(maxArea, (i-indexStack.peek()-1) * heights[index]);
            }
            indexStack.push(i);
        }

        while (indexStack.peek() != -1 ){
            int index = indexStack.pop();
            maxArea = Math.max(maxArea, (heights.length-indexStack.peek()-1) * heights[index]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        new LargestRectangleinHistogram().largestRectangleArea(new int[]{2,1,2});
    }
}
