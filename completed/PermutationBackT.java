package completed;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PermutationBackT {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
     
        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            LinkedHashMap<Integer, Integer> subSetCopy = new LinkedHashMap<>();
            generatePermutation(nums,combinations, subSetCopy, i);   
        }

    }
    
    public static void generatePermutation(int[]nums,List<List<Integer>> combinations,  LinkedHashMap<Integer, Integer> subSet,int index) {
        
        if(subSet.size() == nums.length) return;
        if (subSet.containsKey(nums[index])) return;

        LinkedHashMap<Integer, Integer> subSetCopy = new LinkedHashMap<>();
        subSetCopy.putAll(subSet);

        subSetCopy.put(nums[index], nums[index]);
        if (subSetCopy.size() == nums.length){
            combinations.add(new ArrayList<>(subSetCopy.keySet()));
            return;
        }
             
        int i = index+1;
        while (i >= 0) {
            if (i >= nums.length) break;
            generatePermutation(nums,combinations, subSetCopy, i);
            i++;
        }

        i = index-1;
        while (i >= 0) {
            if (i < 0) break;
            generatePermutation(nums,combinations, subSetCopy, i);
            i--;
            
        }
    }
}
