import java.util.HashMap;

public class HouseRobberDP {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        HashMap<Integer, Integer> housesRobbed = new HashMap<>();
        for (int i = nums.length-1; i >=0; i--) {
            if(i == nums.length-1) housesRobbed.put(i, nums[i]);
            else if(i == nums.length-2) housesRobbed.put(i, nums[i]);
            else {
                housesRobbed.put(i,nums[i] + getMax(housesRobbed, i));
            }
        }
    }
    
    public static int getMax(HashMap<Integer, Integer> housesRobbed, int index) {
        int max = 0;
        index = index+2;
        for (int i = 0; i < housesRobbed.size(); i++) {
            if (!housesRobbed.containsKey(index)) continue;
            if (max < housesRobbed.get(index)) max = housesRobbed.get(index);
            index++;
        }
        return max;
    }
}
