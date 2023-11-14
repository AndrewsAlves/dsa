
import java.util.Arrays;
import java.util.HashMap;

/*
 * 
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 * 
 */

public class TwoSum {
    public static void main(String[] args) { 
        int[] array = {3,2,95,4,-3};
        int target = 92;
        TwoSum format = new TwoSum();
        int[] result = format.twoSum(array,target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length;i++) {
            hashmap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int x = 0;
            /*if (target > nums[i]){
                x = target - nums[i]; 
            } else {
                x = nums[i] - target;
            }*/

            x = Math.abs(nums[i] - target);
            if ((nums[i] + (x * -1)) == target) {
                x = x * -1;
            }

            System.out.println(x);

            if (hashmap.containsKey(x)) {
                int index2 = hashmap.get(x);
                if (i == index2) continue;
                return new int[]{i,hashmap.get(x)};
            }
        }

        return new int[]{0,0};
    }
}
