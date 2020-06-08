package vivo;

import java.util.Scanner;

/**
 * @author jgz
 * @Date 2020-06-07 15:27
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K,N;
        K = sc.nextInt();
        N = sc.nextInt();
        int[][] dp = new int[K+1][N+1];
        int m = 0;
        while (dp[K][m] < N){
            m++;
            for (int k=1;k<=K; k++){
                dp[k][m] = dp[k][m-1] + dp[k-1][m-1]+1;
            }
        }
        System.out.println(m);
    }


}
