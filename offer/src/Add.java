/**
 * @author jgz
 * @Date 2020-03-30 12:13
 */
public class Add {
    public int add(int a, int b) {
        while (a != 0){
            int plus = a ^ b;
            a = (a & b) << 1;
            b = plus;
        }
        return b;
    }

    public static void main(String[] args) {

    }
}
