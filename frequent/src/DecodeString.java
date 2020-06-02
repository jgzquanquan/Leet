import java.util.Collections;
import java.util.Stack;

/**
 * @author jgz
 * @Date 2020-05-28 08:28
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i<chars.length; i++){
            if (Character.isDigit(chars[i])){
                num.append(chars[i]);
            } else if (chars[i] == '['){
                if (num.length() != 0){
                    stack.push(Integer.valueOf(num.toString()));
                }
                num = new StringBuilder();
            } else if (chars[i] == ']'){
                StringBuilder tmp = new StringBuilder();
                while (!stack.isEmpty() && !(stack.peek() instanceof Integer)){
                    tmp.append(stack.pop());
                }
                Integer times = (Integer) stack.pop();
                String cur = String.join("", Collections.nCopies(times,tmp.toString()));
                stack.push(cur);
            } else {
                stack.push(String.valueOf(chars[i]));
            }
        }
        StringBuilder tmp = new StringBuilder();
        while (!stack.isEmpty() && !(stack.peek() instanceof Integer)){
            tmp.append(stack.pop());
        }
        return tmp.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]").toString());
    }
}
