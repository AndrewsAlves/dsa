import java.util.HashMap;

public class HouseRobber2DP {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,1,2,3,4,5};
        System.out.println(rob(nums));

    }

    public static int rob(int[] nums) {
        
        if (nums.length == 0 ) return 0;
        if (nums.length == 1) return nums[0];

        HashMap<Integer, int[]> hashMap = new HashMap<>();
        HashMap<Integer, int[]> hashMap2 = new HashMap<>();
        for (int i = nums.length-1; i >=0 ; i--) {
            if (i == nums.length-1) {
                int[] value = {nums[i],1};
                hashMap.put(i, value);
                System.out.println(value[0] + " " + value[1]);
            } else if (i == nums.length-2) {
                int[] value = {nums[i],0};
                hashMap.put(i, value);
                System.out.println(value[0] + " " + value[1]);
            } else {
                int[] v = getMaximumRobbed(nums, i, hashMap);
                int[] value = {nums[i] + v[0], v[1]};
                hashMap.put(i, value);
                System.out.println(value[0] + " " + value[1]);
            }
        }

        System.out.println(" ");

        for (int i = nums.length-2; i >=0 ; i--) {
            if (i == nums.length-2) {
                int[] value = {nums[i],0};
                hashMap2.put(i, value);
                System.out.println(nums[i] + " " + 0);
            } else {
                int[] v = getMaximumRobbed(nums, i, hashMap2);
                int[] value = {nums[i] + v[0], v[1]};
                hashMap2.put(i, value);
                System.out.println(value[0] + " " + value[1]);
            }
        }

        return Math.max(getMaximumRobbed(nums, -2, hashMap)[0], getMaximumRobbed(nums, -2, hashMap2)[0]);
    }

    public static int[] getMaximumRobbed(int[] nums, int index, HashMap<Integer, int[]> hashMap) {
        boolean omitLastHouse = false;
        if (index == 0) omitLastHouse = true;
        index = index+2;
        int[] max = new int[2];
        for (int i = 0; i < hashMap.size(); i++) {
            if (!hashMap.containsKey(index)) continue;
            int[] value = hashMap.get(index);
            if (omitLastHouse) {
                if (value[1] != 1) if (max[0] < value[0]) max = value; 
            } else {
                if (max[0] < value[0]) max = value; 
            }
            index++;
        }
        return max;
    }
}
