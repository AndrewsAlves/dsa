import java.util.*;
public class LongestIncreasingSubDP {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7};
        int[] maxSubSequence = new int[nums.length];
        int[] longestSub = {1};
        for (int i = nums.length-1; i >= 0; i--) {
            if (i == nums.length-1) {
                maxSubSequence[i] = 1;
                continue;
            }
            getLongestSub(nums, maxSubSequence, i, longestSub);
    
        }
        System.out.println(longestSub[0]);
    }

    public static void getLongestSub(int[] nums, int[] maxSubSequence, int index, int[] longestSub) {
        int increasingInt = 1;
        for (int i = index+1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                if (longestSub[0] < maxSubSequence[i] + 1) longestSub[0] = maxSubSequence[i] + 1;
                if (increasingInt < maxSubSequence[i] + 1) increasingInt = maxSubSequence[i] + 1;
            }
        }

        maxSubSequence[index] = increasingInt;

    }
}
