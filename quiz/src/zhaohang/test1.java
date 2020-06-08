package zhaohang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jgz
 * @Date 2020-04-29 09:05
 */
public class test1 {


//    private static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int rowNum = Integer.parseInt(str);
        int[][] coins = new int[rowNum][rowNum];
//        for (int[] coin : coins){
//            Arrays.fill(coin, -1);
//        }
        for (int i=0; i<rowNum; i++){
            String row = sc.nextLine();
            String[] strings = row.split(" ");
            for (int j=0; j<=i; j++){
                coins[i][j] = Integer.parseInt(strings[j]);
            }
        }
//        int[][] dp = new int[rowNum][rowNum];
        for (int i = rowNum-2; i>=0; --i){
            for (int j = 0; j<=i; j++){
                coins[i][j] += Math.max(coins[i+1][j],coins[i+1][j+1]);
            }
        }
        System.out.println(coins[0][0]);
    }

    private static void dfs(int[][] coins, int i, int j, int sum) {
//        if (i == coins.length && (j >= 0 && )){
//
//        }
    }
}
