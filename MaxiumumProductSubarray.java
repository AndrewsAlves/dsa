public class MaxiumumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {-3,0,1,-2};

        int[] maxProduct = {Integer.MIN_VALUE};
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if (maxProduct[0] < nums[i]) maxProduct[0] = nums[i];
                continue;
            }
            getMaxProductSubArray(nums, i, 1, maxProduct, 1);
        }

        System.out.println(maxProduct[0]);
    }

    public static void getMaxProductSubArray(int[] nums, int index, int length, int[] maxProduct, int previousProduct) {
        if (length > nums.length || index >= nums.length) return;
        int currentProduct = 0;
        if (length == 1) currentProduct = nums[index];
        else {
            currentProduct = previousProduct * nums[index];
        }
        if (maxProduct[0] < currentProduct) maxProduct[0] = currentProduct;
        getMaxProductSubArray(nums, index+1, length+1, maxProduct, currentProduct);
    }
}
