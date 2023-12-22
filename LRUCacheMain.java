import java.util.LinkedHashMap;

public class LRUCacheMain {
}

class LRUCache {

    LinkedHashMap<Integer, Integer> linkedHashMap;
    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            int value = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            return value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
        } else {
            if (linkedHashMap.size() < capacity) {
                linkedHashMap.put(key, value);
            } else {
                linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
                linkedHashMap.put(key, value);
            }
        }
    }
}
