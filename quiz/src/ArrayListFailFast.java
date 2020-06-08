import java.util.ArrayList;
import java.util.List;

/**
 * @author jgz
 * @Date 2020-05-01 00:01
 */
public class ArrayListFailFast {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        for (String s : list){
            if ("one".equals(s)){
                list.remove(s);
            }
        }
        System.out.println(list);
    }
}
