import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public interface SubSetBackT {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subSet = new ArrayList<>();
        subSet.add(new ArrayList<>());
        Arrays.sort(nums);
        generateSubset(subSet, nums, 0, new ArrayList<>());
    }

    public static void generateSubset(List<List<Integer>> subSet, int[] nums, int index, List<Integer> desList) {
        List<Integer> des1 = new ArrayList<>(desList);
        if (index >= nums.length) {
            if (des1.isEmpty()) return;
            addCombination(subSet, des1);
            return;
        }
        des1.add(nums[index]);
        generateSubset(subSet, nums, index+1, des1);
        generateSubset(subSet, nums, index+1, desList);
    }

    public static void addCombination(List<List<Integer>> sumCombination, List<Integer> subSeq) {
        
        for (List<Integer> subSet : sumCombination) {
            if (subSet.equals(subSeq)) return;
        }

        sumCombination.add(subSeq);

        return;
    }

}
