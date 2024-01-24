import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class CheapestFlightKStops2 {

    int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
    int src = 0, dst = 3, k = 1, n = 4;
    HashMap<Integer, TreeMap<Integer, Integer>> grHashMap;
    PriorityQueue<Integer> costToDest;

    public static void main(String[] args) {

        CheapestFlightKStops2 cc = new CheapestFlightKStops2();
        cc.cc();
    }

    public void cc() {
        grHashMap = new HashMap<>();

        for (int i = 0; i< flights.length; i++) {
            int source = flights[i][0], dest = flights[i][1], cost = flights[i][2];
            if (grHashMap.containsKey(source)) {
                grHashMap.get(source).put(dest, cost);
            } else {
                TreeMap<Integer, Integer> destMap = new TreeMap<>();
                destMap.put(dest, cost);
                grHashMap.put(source, destMap);
            }
        }

        costToDest = new PriorityQueue<>();

        dfs(src, -1, 0, new boolean[n]);

        System.out.println(costToDest.poll());
    }

    public void dfs(int city, int noOfStop, int totalCost, boolean[] visited) {

        noOfStop++;
        if (noOfStop > k && city != dst) {
            return;
        }

        if (city == dst) {
            costToDest.add(totalCost);
            return;
        }

        visited[city] = true;

        HashMap<Integer, Integer> destHashMap = grHashMap.get(city);
        for (int dest : destHashMap.keySet()) {
            if (dest != dst && visited[dest]) continue;
            dfs(dest, noOfStop, totalCost + destHashMap.get(dest), visited);
            visited[dest] = false;
        }
    }
}
