import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Set;
/**
 * NetworkDelayTime
 */
public class NetworkDelayTime {

    public static void main(String[] args) {

        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int k = 2, n = 4;
        boolean[] visited = new boolean[n+1];
        HashMap<Integer, Integer> nodesDistance = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> grMap = new HashMap<>();
        PriorityQueue<int[]> minDistHeap = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        minDistHeap.add(new int[]{0,k});
        nodesDistance.put(k, 0);

        for (int i = 0; i < times.length; i++) {
            int node = times[i][0], desNode = times[i][1], weight = times[i][2];

            if (grMap.containsKey(node)) {
                grMap.get(node).put(desNode, weight);
            } else {
                HashMap<Integer, Integer> deHashMap = new HashMap<>();
                deHashMap.put(desNode, weight);
                grMap.put(node, deHashMap);
            }
        }

        while (!minDistHeap.isEmpty()) {
            int[] edge = minDistHeap.poll();
            int node = edge[1], distance = edge[0];
            //System.out.println(node);
            if (visited[node]) continue;
            
            visited[node] = true;
            
            if (!grMap.containsKey(node)) continue;

            for (int desNodes : grMap.get(node).keySet()) {
                if (visited[desNodes]) continue;
                int nodeDis = distance + grMap.get(node).get(desNodes);
                int[] nodeDist = {nodeDis, desNodes};
                minDistHeap.add(nodeDist);
                if (nodesDistance.containsKey(desNodes)) {
                    if (nodesDistance.get(desNodes) > nodeDis)nodesDistance.put(desNodes, nodeDis);
                } else {
                    nodesDistance.put(desNodes, nodeDis);
                }
                
            }
        }

        if (nodesDistance.size() != n) return -1;

        int minCount = Integer.MIN_VALUE;
        for (int distances : nodesDistance.values()) {
            //System.out.println(distances);
            if (minCount < distances) minCount = distances;
        }

        System.out.println(minCount);
    }
}