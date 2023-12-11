public class MinimumInRotatedArray {
    public static void main(String[] args) {
        int[] nums= {11,13,15,17};
        System.out.println(findMin(nums));
    }

    public static int findMin(int [] nums) {
        return find(nums, 0, nums.length-1, nums[0]);
    }

    public static int find(int[] nums, int l, int r, int lowest) {
        int low = Math.min(Math.min(nums[l], nums[r]), lowest);
        if (l == r-1) return low;
        if (l == r) return low;
        else low = find(nums, l+1, r-1, low);
        return low;
    }
}
