import java.util.Scanner;
import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-04-12 16:11
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int c1=0, cl=0, cr=0;
        for (Character c : s.toCharArray()){
            if (c == '('){
                stack.add('(');
                cl++;
            }else if (c == ')'){
                if (!stack.isEmpty()){
                    stack.pop();
                    c1++;
                    cl--;
                }else {
                    cr++;
                }
            }
        }
        System.out.printf("%d %d %d",c1,cl,cr);
    }
}
