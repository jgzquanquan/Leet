//50
public class Pow {
    public double myPow(double x, int n) {
        long N = n;
        if(n<0){
            x = 1/x;
            N = -N;
        }
        return half(x,N);

    }

    public double half(double x,long n){
        if (n==0) {
            return 1;
        }
        if (n%2==1){
            return x*half(x,n-1);
        }else {
            return half(x * x, n / 2);
        }
    }
}
