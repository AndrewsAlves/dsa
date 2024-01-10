import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.TreeMap;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        TreeMap<Double, ArrayDeque<Integer>> map = new TreeMap<>();
        double x =0, y = 0;
        for (int i= 0; i < points.length; i++) {
            x = points[i][0];
            y = points[i][1];
            double eucilenDis = Math.pow((x - 0),2) + Math.pow((y - 0),2);
            if (map.containsKey(eucilenDis)) {
                map.get(eucilenDis).add(i);
            } else {
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.add(i);
                map.put(eucilenDis, q);
            }
            
        }

        int[][] result = new int[k][2];
        int i = 0;
        for (double key : map.keySet()) {
            if (i > k-1) break;
            ArrayDeque<Integer> q = map.get(key);
            while (!q.isEmpty()) {
                result[i] = points[q.poll()];
                i++;
            }
            
        }
    }
}
