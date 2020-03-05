/**
 * @author jgz
 * @Date 2020-03-03 11:05
 */
public class MinArray {
    public int minArray(int[] numbers) {
        for(int i=1; i<numbers.length; i++){
            if (numbers[i] < numbers[i-1]) return numbers[i];
        }
        return numbers[0];
    }

    public int minArray1(int[] numbers) {
        if(numbers == null || numbers.length == 0) return 0;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else if (numbers[mid] < numbers[right]){
                right = mid;
            }else {
                right = right - 1;
            }
        }
        return numbers[left];
    }

    public int minArray2(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        return minArray(numbers, 0, numbers.length - 1);
    }

    private int minArray(int[] numbers, int left, int right) {
        if (left == right){
            return numbers[left];
        }
        int mid = (left + right) >>> 1;
        if (numbers[mid] > numbers[right]){
            return minArray(numbers, mid + 1, right);
        }else if (numbers[mid] < numbers[right]){
            return minArray(numbers, left, mid);
        }else {
            return minArray(numbers, left, right - 1);
        }
    }
}
