import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class TimeBasedKeyValue {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        timeMap.get("foo", 5);         // return "bar2"
    }
}

class TimeMap {

    HashMap<String,TreeMap<Integer, String>> hashMap;

    public TimeMap() {
        this.hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> list = new TreeMap<>();
            list.put(timestamp, value);
            hashMap.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        if (hashMap.containsKey(key)) {
            TreeMap<Integer, String> list = hashMap.get(key);

            if (list.isEmpty()) return "";

            String value = "";
            if (list.floorKey(timestamp) != null) {
                value = list.get(list.floorKey(timestamp));
            }
            
            return value;
        }

        return "";
    }
}

class ValueTimeStamp {
    public String value;
    public int timestamp;
    public ValueTimeStamp(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
