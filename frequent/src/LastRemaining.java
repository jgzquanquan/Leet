import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-03-30 10:19
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            list.add(i);
        }
        int c = (m-1) % n;
        while (list.size() != 1){
            list.remove(c);
            c = (m-1+c) % list.size();
        }
        return list.get(0);
    }

    public int lastRemaining1(int n, int m) {
        int last = 0;
        for (int i=2; i<=n; i++){
            last = (last+m) % i;
        }
        return last;
    }


}
