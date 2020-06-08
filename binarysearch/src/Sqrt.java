/**
 * @author jgz
 * @Date 2019-11-26 20:34
 */

//69
public class Sqrt {
//    二分查找法
public int mySqrt(int x) {
    if (x < 2) return x;

    long num;
    int pivot, left = 2, right = x / 2;
    while (left <= right) {
        pivot = left + (right - left) / 2;
        num = (long)pivot * pivot;
        if (num > x) right = pivot - 1;
        else if (num < x) left = pivot + 1;
        else return pivot;
    }

    return right;
}

//    牛顿法
    public int mySqrt1(int x) {
        long a = x;
        while (a * a > x){
            a = (a + x / a) / 2;
        }
        return (int) a;
    }
    public static void main(String[] args) {
        new Sqrt().mySqrt(9);
    }
}
