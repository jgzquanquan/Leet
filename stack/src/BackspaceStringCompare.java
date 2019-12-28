import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0;i < S.length();i++){
            if (S.charAt(i) == '#'){
                if (stackS.empty()){
                    continue;
                }
                stackS.pop();
            }else {
                stackS.push(S.charAt(i));
            }
        }
        for (int i = 0;i < T.length();i++){
            if (T.charAt(i) == '#'){
                if (stackT.empty()){
                    continue;
                }
                stackT.pop();
            }else {
                stackT.push(T.charAt(i));
            }
        }
        if (stackS.equals(stackT)){
            return true;
        }else {
            return false;
        }
    }

}
