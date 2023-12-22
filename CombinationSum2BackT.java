import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum2BackT {
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> comSet = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            sum = sum + nums[i];
        }
        Arrays.sort(nums);
        HashMap <Integer, Integer> hashMap = new HashMap<>();
        HashMap <Integer, Integer> mapRecurrion = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if (mapRecurrion.containsKey(nums[i])) continue;
            mapRecurrion.put(nums[i], 0);
            generateCombination(nums, target, i,0,comSet, hashMap);
        }
    }

    public static void generateCombination(int[] nums, int target,int index,int sum, List<List<Integer>> comSet, HashMap <Integer, Integer> comSubSet) {

        if (nums[index] > target) return;
        
        HashMap <Integer, Integer> comSubSetCopy = new HashMap<>();
        HashMap <Integer, Integer> mapRecurrion = new HashMap<>();
        comSubSetCopy.putAll(comSubSet);

        if ((sum + nums[index]) == target) {
            comSubSetCopy.put(index, nums[index]);
            addCombination(comSet, comSubSetCopy);
            return;
        }

        if ((sum + nums[index]) > target) return;

        comSubSetCopy.put(index, nums[index]);

        int currentSum = sum + nums[index];
        for (int i = 0; i < nums.length ; i++) {
            if (comSubSetCopy.containsKey(i)) continue;
            if (mapRecurrion.containsKey(nums[i])) continue;
            mapRecurrion.put(nums[i], 0);
            generateCombination(nums, target, i, currentSum, comSet, comSubSetCopy);
        }

    }

    public static boolean addCombination(List<List<Integer>> comSet,HashMap <Integer, Integer> comSubSet) {
        if (comSet.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>(comSubSet.values());
            list.sort(Comparator.naturalOrder());
            comSet.add(list);
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>(comSubSet.values());
        list.sort(Comparator.naturalOrder());
        for(List<Integer> subList : comSet) {
            if (subList.equals(list)) {
                System.out.println("Found Duplicate =" + subList.get(0));
                return false;
            }
        }
        comSet.add(list);
        return true;
    }
}
