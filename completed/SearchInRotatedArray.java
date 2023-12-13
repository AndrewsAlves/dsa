package completed;
public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int [] nums, int target) {
        return find(nums, 0, nums.length-1, target);
    }

    public static int find(int[] nums, int l, int r, int target) {
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        if (l >= r) return -1;
        return find(nums, l+1, r-1, target);
    }
}
