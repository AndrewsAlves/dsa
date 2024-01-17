import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{2,3},{5,5},{2,2},{3,4},{3,4}};
        List<int[]> intervalList = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        
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

        for (int i = 0; i < intervalList.size(); i++ ) {
            int[] res = {intervalList.get(i)[0], 0};
            int start = res[0];
            int maxEnd = intervalList.get(i)[1];
            for (int j = i+1; j < intervalList.size(); j++ ) {
                int nexIntStart = intervalList.get(j)[0];
                int nexIntEnd = intervalList.get(j)[1];
                if (nexIntStart > maxEnd) {
                    i = j-1;
                    break;
                }
                if (nexIntStart >= start && nexIntStart <= maxEnd) {
                    maxEnd = Math.max(maxEnd, nexIntEnd);
                }
                i = j;
            }
            res[1] = maxEnd;
            result.add(res);
        }

        int[][] resultArr = new int[result.size()][2];
        for (int i = 0; i< result.size();i++) {
            resultArr[i] = result.get(i);
        }

        //return resultArr;
    }
}
