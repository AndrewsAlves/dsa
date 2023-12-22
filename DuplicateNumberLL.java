import java.util.Arrays;

public class DuplicateNumberLL {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
    }

    public static int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            if (i == 0) continue;
            if (nums[i] == nums[i-1]) return nums[i];
        }

        return 0;
    }

}
