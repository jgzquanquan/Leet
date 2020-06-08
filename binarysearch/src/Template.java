/**
 * @author jgz
 * @Date 2020-03-23 11:06
 */
public class Template {
    public int binarySearch(int[] arr, int target){
        int left = 0, right = arr.length-1;
        int res = -1;
        while (left <= right){
            int mid = left +  (right - left) >> 1;
            if (arr[mid] == target){
                //返回或者做其他处理
                res = mid;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return res;
    }
}
