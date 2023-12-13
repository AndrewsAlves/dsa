package completed;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;

public class LongestConsicutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsicutiveSequence(nums));
    }

    public static void printList(List<Integer> arr) {
        for(int i : arr) {
            System.out.println(i);
        }
    }

    public static int longestConsicutiveSequence(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
 
        for(int num : nums) {
            treeMap.put(num, num);
        }

        int consCount = 1;
        int maxCount = 1;

        List<Integer> ketList = new ArrayList<>(treeMap.keySet());
        printList(ketList);

        for (int i = 0 ; i < ketList.size() ; i++){
            if (i == ketList.size() - 1) break;
            int num = treeMap.get(ketList.get(i));
            int cons = treeMap.get(ketList.get(i+1));
            if (cons == num+1) {
                consCount++;
            } else {
                consCount = 1;
            }
            if (maxCount < consCount) {
                maxCount = consCount;
            }
        }

        return maxCount;
    }
}
