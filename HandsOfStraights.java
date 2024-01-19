import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandsOfStraights {
    public static void main(String[] args) {
        
        int[] hand = {2,1};
        int groupSize = 2;

        System.out.println(system(hand, groupSize));
        
    }

    public static boolean system(int[] hand, int groupSize) {
        if ((hand.length % groupSize) != 0) return false;

        Arrays.sort(hand);
        List<List<Integer>> result = new ArrayList<>();

        int i = 0;
        boolean grouped = false;
        List<Integer> group = new ArrayList<>();
        int preVal = -1;
        int resultSize = hand.length / groupSize;
        while (!grouped) {

            if (i >= hand.length) return false;

            if (hand[i] == -1) {
                i++;
                continue;
            }

            if (preVal == -1) preVal = hand[i]-1;

            if (hand[i] != -1 && hand[i] == preVal+1) {
                group.add(hand[i]);
                preVal = hand[i];
                hand[i] = -1;
            }
            if (group.size() == groupSize)  {
                result.add(group);
                group = new ArrayList<>();
                preVal = -1;
                i = -1;
            }
            if (result.size() == resultSize) {
                return true;
            }
            i++;
        }

        return true;
    }


}
