package completed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] input = {1,2};
        int k = 2;

        print(topKFrequentElements(input, k));
    }

    public static void print(int[] iArr) {
        System.out.println(" ");
        for (int i = 0; i<iArr.length ;i++) {
            System.out.println(iArr[i]);
        }
    }

    public static int[] topKFrequentElements(int[] input, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : input) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, 1);
            } else {
                hashMap.put(i, hashMap.get(i) + 1);
            }
        }

        Map<Integer, Stack<Integer>> hashMap2 = new TreeMap<>();
        for (int key : hashMap.keySet()) {
            int val = hashMap.get(key);
            if (hashMap2.containsKey(val)) {
                Stack<Integer> i = hashMap2.get(val);
                i.push(key);
                hashMap2.put(val, i);
            } else {
                Stack<Integer> i = new Stack<>();
                i.push(key);
                hashMap2.put(val, i);
            }
        }

        int[] output = new int[k];
        List<Integer> set = new ArrayList<>(hashMap2.keySet());
        int ikey = hashMap2.keySet().size() - 1;

        System.out.println(hashMap2.keySet().size());

        for (int i = 0; i < k ; i++) {
            if (!hashMap2.get(set.get(ikey)).empty()) {
                output[i] = hashMap2.get(set.get(ikey)).pop();
            } else {
                ikey--;
                output[i] = hashMap2.get(set.get(ikey)).pop();
            }
        }

        return output;
    }
}
