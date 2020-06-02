import java.util.HashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-03-27 10:08
 */
public class XofaKindinaDeckofCards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : deck){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int length = deck.length;
        for (int i=2; i<length; i++){
            if (length%i!=0){
                continue;
            }
            boolean flag = true;
            for (int num : map.values()){
                if (num % i != 0){
                    flag = false;
                    break;
                }
            }
            if (flag) return flag;
        }
        return false;
    }

    public boolean hasGroupsSizeX1(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : deck){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int g = -1;
        for (int num : map.values()){
            if (g == -1)
                g = num;
            else
                g = gcd(g, num);
        }
        return g>=2;
    }

    public int gcd(int x, int y) {
        if (x == 0) return x;
        int r;
        while (y > 0){
            r = x % y;
            x = y;
            y = r;
        }
        return x;
    }


}
