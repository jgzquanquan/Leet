/**
 * @author jgz
 * @Date 2020-03-06 20:15
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        boolean point = false;
        boolean e = false;
        boolean number = false;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                number = true;
            }else if (s.charAt(i) == '.'){
                if (e || point){
                    return false;
                }
                point = true;
            }else if (s.charAt(i) == 'e'){
                if (e || !number){
                    return false;
                }
                e = true;
                number = false;
            }else if (s.charAt(i) == '+' || s.charAt(i) == '-'){
                if (i != 0 && s.charAt(i-1) != 'e'){
                    return false;
                }
            }else {
                return false;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        new ValidNumber().isNumber(".9e1") ;
    }
}
