/**
 * @author jgz
 * @Date 2020-03-31 11:11
 */
public class ConstructArr {
//    暴力法
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        for (int i=0; i<b.length; i++){
            int ans = 1;
            for (int j=0; j<a.length;j++){
                if (j==i) continue;
                ans *= a[j];
            }
            b[i] = ans;
        }
        return b;
    }

    public int[] constructArr1(int[] a) {
        if (a == null || a.length == 0){
            return new int[0];
        }
        int[] c = new int[a.length];
        c[0] = 1;
        for (int i=1; i<a.length; i++){
            c[i] = c[i-1] * a[i-1];
        }

        int temp = 1;
        for (int i=a.length-2; i>=0; i--){
            temp *= a[i+1];
            c[i] *= temp;
        }
        return c;
    }

    public static void main(String[] args) {
        new ConstructArr().constructArr1(new int[]{1,2,3,4,5});
    }
}
