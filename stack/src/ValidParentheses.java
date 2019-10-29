import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> stringHashMap = new HashMap<>();
        stringHashMap.put(')','(');
        stringHashMap.put('}','{');
        stringHashMap.put(']','[');
        Stack<Character> stack = new Stack<>();
        char[] characters = s.toCharArray();
        for (int i=0;i<characters.length;i++){
            if (stringHashMap.containsValue(characters[i])){
                stack.push(characters[i]);
            }else if (!stack.empty() && stack.peek().equals(stringHashMap.get(characters[i]))){
                stack.pop();
            }else {
                return false;
            }
        }
        if (stack.empty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("["));
    }
}
