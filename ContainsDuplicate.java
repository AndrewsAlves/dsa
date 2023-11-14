
import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    // CONTAINS DUPLICATE LEETCODE
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

        for (int i = 0; i<nums.length;i++) {
            if (hashmap.containsKey(nums[i])) {
                return true;
            } else {
                hashmap.put(nums[i], nums[i]);
            }
        }

        return false;
    }

}