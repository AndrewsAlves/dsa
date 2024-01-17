import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * InsertInterval
 */
public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        boolean newIntervalMerged = false;
        //TreeMap<Integer, List<Integer>> intervalMap  = new TreeMap<>();
        List<int[]> intervalList = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        int[] lastInterval = new int[2];

        /*List<Integer> temp = new ArrayList<>();
        temp.add(newInterval[1]);
        intervalMap.put(newInterval[0], temp);

        for (int[] n : intervals) {
            if (intervalMap.containsKey(n[0])) {
                intervalMap.get(n[0]).add(n[1]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(n[1]);
                intervalMap.put(n[0], l);
            }
        }*/

        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(intervals[i]);
        }

        if (newInterval[0] <= intervalList.get(0)[0]) {
            intervalList.add(0, newInterval);
            newIntervalMerged = true;
        }
        if (newInterval[0] > intervalList.get(intervalList.size()-1)[0]) {
            intervalList.add(intervalList.size(), newInterval);
            newIntervalMerged = true;
        }

        for (int i = 0; i < intervals.length; i++) {
            if (newIntervalMerged) break;
            if (newInterval[0] > intervalList.get(i)[0] && newInterval[0] <= intervalList.get(i+1)[0]) {
                intervalList.add(i+1, newInterval);
                break;
            }
        }

        for (int[] i : intervalList) {
            System.out.println(i[0]+ " " + i[1]);
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