public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = {5,25,75};
        int target = 100;
        int[] result = twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers.length == 2) {
            result[0] = 1;
            result[1] = 2;
            return result;
        }

        for (int i = 0; i < numbers.length ; i++) {
            int diff = target - numbers[i];
            result[0] = i+1;

            int l = i+1;
            int h = numbers.length-1;
            int index = binarySearch(numbers, diff, l, h);
            if (index != -1) result[1] = index+1;

            if (result[1] != 0) {
                break;
            }
        }

        return result;
    }

    public static int binarySearch(int[] nums,int target,  int l, int h) {

        int mid = (int)((h+l)/2);

        System.out.println(l + " " + mid + " " + h);

        if (target < nums[l] || target > nums[h]) return -1;

        if (nums[l] == target) return l;
        if (nums[h] == target) return h;
        if (nums[mid] == target) return mid;

        if (l == h) return -1;

        int index = -1;

        if (target < nums[mid]) {
            index = binarySearch(nums, target, l, mid-1); 
        } else {
            index = binarySearch(nums, target, mid+1, h);
        }

        return index;
    }

}
