/**
 * @author jgz
 * @Date 2020-03-05 16:06
 */
public class PrintToMaxOfDigits {
    public static void printToMaxOfDigits(int n){
        if (n <= 0) return;
        char[] num = new char[n];
        for (int i = 0; i < num.length; i++){
            num[i] = '0';
        }
        for (int i = 0; i < 10; i++){
            num[0] = (char)(i + '0');
            printToMaxOfDigitsRecursively(num, n ,0);
        }
    }

    private static void printToMaxOfDigitsRecursively(char[] num, int n, int index) {
        if (index == n-1){
            printNum(num);
            return;
        }
        for (int i = 0; i < 10; i++){
            num[index + 1] = (char)(i + '0');
            printToMaxOfDigitsRecursively(num, n, index + 1);
        }
    }

    private static void printNum(char[] num) {
        boolean isBegin0 = true;
        int length = num.length;
        for (int i = 0; i < length; i++){
            if (isBegin0 && num[i] != '0'){
                isBegin0 = false;
            }
            if (!isBegin0){
                System.out.println(num[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printToMaxOfDigits(3);
    }
}
