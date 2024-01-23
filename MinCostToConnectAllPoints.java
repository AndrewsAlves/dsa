import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{3,12},{-2,5},{-4,1}};

        int minCost = 0;
        boolean[] visited = new boolean[points.length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0,0,0});
        HashMap<Integer, Integer> hashMap= new HashMap<>();
        hashMap.put(0, 0);

        while (!minHeap.isEmpty()) {
            int[] edge = minHeap.poll();
            int w = edge[0];
            int node = edge[1];
            int desNode = edge[2];

            if (visited[desNode] || hashMap.getOrDefault(desNode, Integer.MAX_VALUE) < w) continue;

            visited[desNode] = true;
            minCost += w;
            
            for (int i = 0; i < points.length; i++) {
                if (visited[i]) continue;
                int cost = Math.abs(points[desNode][0] - points[i][0]) + Math.abs(points[desNode][1] - points[i][1]);
                if (cost < hashMap.getOrDefault(i, Integer.MAX_VALUE)) {
                    hashMap.put(i, cost);
                    minHeap.add(new int[]{cost, desNode, i});
                }
            }
        }

        System.out.println("");
        System.out.println(minCost);
 
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

    public static void removeEdge(int[] edge,  HashMap<Integer, Set<Integer>> grMap) {
        if (grMap.containsKey(edge[0])) {
            grMap.get(edge[0]).remove(edge[1]);
        }
        if (grMap.containsKey(edge[1])) {
            grMap.get(edge[1]).remove(edge[0]);
        }
    }

    public static boolean hasCycleDfs(int node, HashMap<Integer, Set<Integer>> grMap, Set<Integer> prevNodes, int parentNode) {
        Set<Integer> preNodeCopy = new HashSet<>(prevNodes);
        preNodeCopy.add(node);
        boolean hasCycle = false;
        for (int dest : grMap.get(node)) {
            if (dest == parentNode) continue;
            if (preNodeCopy.contains(dest)) return true;
            hasCycle = hasCycleDfs(dest, grMap, preNodeCopy, node);
            if (hasCycle) return true;
        }

        return false;
    }
}
