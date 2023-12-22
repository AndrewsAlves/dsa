import java.util.HashMap;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] stairsCosts = {1,100,1,1,1,100,1,1,100,1};

        int totalCost[] = new int[1];
        totalCost[0] = Integer.MAX_VALUE;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        //minCost2(stairsCosts,-1,totalCost,new int[1]);
        //System.out.println(totalCost[0]);
        for (int i = stairsCosts.length-1; i >= 0 ; i--) {
            if (i == stairsCosts.length-1) indexMap.put(i, stairsCosts[i]); 
            else if (i == stairsCosts.length-2) indexMap.put(i, stairsCosts[i]); 
            else indexMap.put(i, stairsCosts[i] + Math.min(indexMap.get(i+1), indexMap.get(i+2)));
        }
        System.out.println(indexMap.get(0));
    }
}
