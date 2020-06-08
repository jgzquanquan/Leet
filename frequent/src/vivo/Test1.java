package vivo;

import java.util.Scanner;

/**
 * @author jgz
 * @Date 2020-06-07 15:09
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int cnt = 0;
        for (int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            if(array[i] == 1){
                continue;
            }

            if ((i-1>=0 && array[i-1]==1) || (i+1<n && array[i+1]==1)){
                continue;
            }

            array[i] = 1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
