package completed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UniqueCombinationBackT {
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> sumCombination = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            generateCombination(nums,target,sumCombination, new ArrayList<>(), i, 0);
        }
    }

    public static boolean generateCombination(int[]nums,int target,List<List<Integer>> sumCombination, List<Integer> subSeq, int index, int sum) {
        List<Integer> copySubSeq = new ArrayList<>(subSeq);

        int newSum = sum + nums[index];
        int diff = target - newSum;
        if (diff < 0) return false;

        copySubSeq.add(nums[index]);

        if (newSum == target) {
            return addCombination(sumCombination, copySubSeq);
        }

        int searchResult = Arrays.binarySearch(nums, diff);
        if (searchResult >= 0) {
            boolean combExits = generateCombination(nums, target, sumCombination, copySubSeq, searchResult, newSum)
            if (combExits) {
                for(int i = 0; i < nums.length; i++) {
                    generateCombination(nums,target,sumCombination, copySubSeq, i, newSum);
                }
            }
        } else {
            for(int i = 0; i < nums.length; i++) {
                generateCombination(nums,target,sumCombination, copySubSeq, i, newSum);
            }
        }

        return false;
    }

    public static boolean addCombination(List<List<Integer>> sumCombination, List<Integer> subSeq) {
        subSeq.sort(Comparator.naturalOrder());
        if (sumCombination.isEmpty()) sumCombination.add(subSeq);
        boolean comExist = false;
        for (List<Integer> list : sumCombination) {
            if (list.equals(subSeq)) return true;
        }
        sumCombination.add(subSeq);
        return false;
    }
}
