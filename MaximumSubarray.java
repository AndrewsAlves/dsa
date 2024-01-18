public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int maxSum = nums[0];
        int i = 0;
        int subSum = 0;
        while (i < nums.length) {
            subSum = Math.max(0, subSum);
            subSum += nums[i];
            maxSum = Math.max(maxSum, subSum);
            i++;
        }
        System.out.println(maxSum);
    }
}
