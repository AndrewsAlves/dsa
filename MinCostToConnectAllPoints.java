import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Set;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{2,-3},{-17,-8},{13,8},{-17,-15}};

        //if (points.length == 1) return 0;

        TreeMap<Integer, Queue<int[]>> edgeList = new TreeMap<>(); 
        for (int i = 0; i < points.length; i++) {
            if (i == points.length-1) break;
            for (int j = i+1; j < points.length; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                if (edgeList.containsKey(cost)) {
                    int[] edge = {i,j};
                    edgeList.get(cost).add(edge);
                } else {
                    int[] edge = {i,j};
                    Queue<int[]> subList = new ArrayDeque<>();
                    subList.add(edge);
                    edgeList.put(cost, subList);
                }                
            }
        }

        HashMap<Integer, Set<Integer>> grMap = new HashMap<>();
        for (int cost : edgeList.keySet()) {

            Queue<int[]> subList = edgeList.get(cost);
            while (!subList.isEmpty()) {
                int[] edge = subList.poll();
                addEdge(edge, grMap);
            }
        }
 
        //return minCost;
    }

    public static void addEdge(int[] edge,  HashMap<Integer, Set<Integer>> grMap) {
        if (grMap.containsKey(edge[0])) {
            grMap.get(edge[0]).add(edge[1]);
        } else {
            Set<Integer> destSet = new HashSet<>();
            destSet.add(edge[1]);
            grMap.put(edge[0], destSet);
        }
        if (grMap.containsKey(edge[1])) {
            grMap.get(edge[1]).add(edge[0]);
        } else {
            Set<Integer> destSet = new HashSet<>();
            destSet.add(edge[0]);
            grMap.put(edge[1], destSet);
        }
    }
}
