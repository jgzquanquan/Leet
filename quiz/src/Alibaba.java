import java.util.Scanner;

/**
 * @author jgz
 * @Date 2020-04-14 12:18
 */
public class Alibaba {
    public int maxPath(){
        int n,m,x;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs=str.split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        x = Integer.parseInt(strs[2]);
        int[][] citys=new int[n+1][n+1];
        while (m>0){
            strs = sc.nextLine().split(" ");
            citys[Integer.parseInt(strs[0])][Integer.parseInt(strs[1])]=Integer.parseInt(strs[2]);
            m--;
        }
        return 0;


    }
}
