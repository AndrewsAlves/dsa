package completed;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * PartitionEqualSubset
 */
public class PartitionEqualSubset {

    public static void main(String[] args) {
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};

        boolean[] canDivide = {false};
        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        HashMap<String, Integer> hashMapPresent = new HashMap<>();
        
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) {
            canDivide[0] = false;
            System.out.println(canDivide[0]);
            return;
        }
        
        sum /= 2;
        
        for (int i = 0; i < nums.length ; i++) {
            calculate(nums,hashMapPresent, canDivide, hashMap, i, 0, sum);
        }
        
        System.out.println(canDivide[0]);
    }

    public static void calculate(int[] nums,HashMap<String, Integer> hashMapPresent, boolean[] canDivide, TreeMap<Integer, Integer> hashMap, int index, int sumSub, int sumBy2, String indexString) {

        if (canDivide[0]) return;

        TreeMap<Integer, Integer> hashMapCopy = new TreeMap<>(hashMap);
        hashMapCopy.put(index, 0);
        sumSub = sumSub + nums[index];

        if (sumSub == sumBy2) {
            canDivide[0] = true;
            return;
        }
        if (sumSub > sumBy2) return;

        if (hashMapCopy.size() >= nums.length-1) return;

        for (int i = 0; i < nums.length ; i++) {
            if (hashMapCopy.containsKey(i)) continue;
            calculate(nums, hashMapPresent, canDivide, hashMapCopy, i, sumSub, sumBy2);
        }
    }

    
}