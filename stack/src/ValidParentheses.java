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

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (c=='(') stack.push(')');
            else if (c=='{') stack.push('}');
            else if (c=='[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("["));
    }
}
