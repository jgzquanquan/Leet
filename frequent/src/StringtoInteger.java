/**
 * @author jgz
 * @Date 2020-04-03 10:18
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        int len = str.length();
        int index = 0;
        while (index < len){
            if (str.charAt(index) != ' ')
                break;
            index++;
        }

        if (index == len){
            return 0;
        }

        int sign = 1;
        char first = str.charAt(index);
        if (first == '+' || first == '-'){
            if (first == '-')
                sign = -1;
            index++;
        }

        int res = 0;
        while (index < len){
            char c = str.charAt(index);
            if (c < '0' || c > '9')
                break;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)){
                return Integer.MAX_VALUE;
            }

            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10))){
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (c - '0');
            index++;
        }
        return res;
    }
}
