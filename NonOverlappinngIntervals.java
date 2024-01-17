import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonOverlappinngIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{2,3},{5,5},{2,2},{3,4},{3,4}};
        List<int[]> intervalList = new ArrayList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                intervalList.add(intervals[i]);
                continue;
            }

            if (intervals[i][0] <= intervalList.get(0)[0]) {
                intervalList.add(0, intervals[i]);
                continue;
            }

            if (intervals[i][0] > intervalList.get(intervalList.size()-1)[0]) {
                intervalList.add(intervalList.size(), intervals[i]);
                continue;
            }
            
            for (int j = 0; j < intervalList.size(); j++) {
                if (intervals[i][0] > intervalList.get(j)[0] && intervals[i][0] <= intervalList.get(j+1)[0]) {
                    intervalList.add(j+1, intervals[i]);
                    break;
                }
            }
        }

        int minOverlap = 0;
        Set<Integer> removedIndex = new HashSet<>();
        for (int i = 0; i < intervalList.size(); i++ ) {
            if (i >= intervalList.size()-1) break;
            if (removedIndex.contains(i)) continue;
            int start = intervalList.get(i)[0];
            int end = intervalList.get(i)[1];

            int j = i+1;
            for (int q = i+1 ; q < intervalList.size(); q++) {
                if (!removedIndex.contains(q)) {
                    j = q;
                    break;
                }
            }

            int nexIntStart = intervalList.get(j)[0];
            int nexIntEnd = intervalList.get(j)[1];
            if (nexIntStart >= start && nexIntStart < end) {
                if (nexIntEnd > end) {
                    removedIndex.add(j);
                    i--;
                } else {
                    removedIndex.add(i);
                }
                minOverlap++;
            }
        }

        return minOverlap;
    }

}
