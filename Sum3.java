import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sum3 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        printList(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<HashMap<Integer,Integer>> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (hashMap.containsKey(key)) {
                List<Integer> q = hashMap.get(key);
                q.add(i);
                hashMap.put(key, q);
            } else {
                List<Integer> q = new ArrayList<>();
                q.add(i);
                hashMap.put(key, q);
            }
        }

        int x,y,z = 0; 
        for (int i = 0 ; i < nums.length - 1; i++) {

            if (i == nums.length -1) break;

            HashMap<Integer,Integer> triplets = new HashMap<>();

            x = nums[i];
            y = nums[i+1];
            int diff = x+y;

            if (diff > 0) diff = -diff;
            else diff = Math.abs(diff);

            //System.out.println(diff);

            if (hashMap.containsKey(diff)) {
                List<Integer> indexList = hashMap.get(diff);
                for (int index : indexList) {
                    if (index != i && index != i+1) {
                        z = nums[index];
                        triplets.put(0, x);
                        triplets.put(1, y);
                        triplets.put(2, z);

                        if (list.isEmpty()) {
                            list.add(triplets);
                        } else {
                            int s = list.size();
                            for (int k = 0; k < s ; k++) {
                                HashMap<Integer, Integer> h = list.get(k);
                                if (!h.containsValue(x) || !h.containsValue(y) || !h.containsValue(z)) {
                                    list.add(triplets);
                                    break;
                                }
                            }    
                        }
                    }
                }
            } else {
                continue;
            }
        }

        List<List<Integer>> list1 = new ArrayList<>();
        for (HashMap<Integer, Integer> map : list) {
            List<Integer> l = new ArrayList<>(map.values());
            list1.add(l);
        }

        return list1;
    }

    public static void printList(List<List<Integer>> list) {
        for (List<Integer> l : list) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }
}
