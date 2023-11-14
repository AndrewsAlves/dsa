
public class BinarySearch {
    public static void main(String[] args) {
        int[] input = {2,5};
        int target = 0;
        BinarySearch bs = new BinarySearch();
        int result = bs.search(input, target);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        int h = nums.length - 1;
        int l = 0;
        int result = bSearch(nums, target, l, h);

        return result;
    }

    public int bSearch(int[] nums,int target, int l, int h) {
        int md = (int)(l+h)/2;

        if (target < nums[l] || target > nums[h]) return -1;

        if (l == h) {
            return -1;
        }

        if (nums[l] == target) {
            return l;
        }
        if (nums[h] == target) {
            return h;
        }
        if (nums[md] == target) {
            return md;
        }

        int result = -1;
        if (nums[md] > target) {
            result = bSearch(nums, target, l, md - 1);
        } else {
            result = bSearch(nums, target, md + 1, h);
        }

        return result;
    }
}
