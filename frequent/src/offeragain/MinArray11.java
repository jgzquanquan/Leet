package offeragain;

/**
 * @author jgz
 * @Date 2020-06-03 09:59
 */
//二分查找法
public class MinArray11 {
    public int minArray(int[] numbers) {
        if(numbers == null || numbers.length == 0){
            return -1;
        }
        int l = 0, r = numbers.length - 1;
        while (l < r){
            int mid = (l+r) >> 1;
            if (numbers[mid] > numbers[r]){
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]){
                r = mid;
            } else {
                r = r-1;
            }
        }
        return numbers[l];
    }
}
