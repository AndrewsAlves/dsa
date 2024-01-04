package completed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * PartitionEqualSubset
 */
public class PartitionEqualSubset2 {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};

        Set<Integer> set = new HashSet<>();
        
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }
        
        sum /= 2;
        
        set.add(0);
        List<Integer> numList = new ArrayList<>();
        for (int i = nums.length-1; i >= 0 ; i--) {
            if (i == nums.length-1) {
                set.add(nums[i]);
                continue;
            }

            int subSum = 0;
            for (int j : set) {
                subSum = nums[i] + j;
                numList.add(subSum);
            }
            set.addAll(numList);
            numList.clear();
        }

        if (set.contains(sum)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        
        //System.out.println(canDivide[0]);
    }

    public static void generateSubset(int[] nums) {

    }

    /*public static void calculate(int[] nums,HashMap<String, Integer> hashMapPresent, boolean[] canDivide, TreeMap<Integer, Integer> hashMap, int index, int sumSub, int sumBy2, String indexString) {

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
    }*/

    
}