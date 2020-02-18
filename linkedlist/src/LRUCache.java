import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jgz
 * @Date 2020-02-16 12:32
 */
public class LRUCache extends LinkedHashMap<Integer,Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {Q
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
}
