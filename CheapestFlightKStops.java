import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CheapestFlightKStops {
    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;

        
        HashMap<Integer, HashMap<Integer, Integer>> grHashMap = new HashMap<>();

        for (int i = 0; i< flights.length; i++) {
            int source = flights[i][0], dest = flights[i][1], cost = flights[i][2];
            if (grHashMap.containsKey(source)) {
                grHashMap.get(src).put(dest, cost);
            } else {
                HashMap<Integer, Integer> destMap = new HashMap<>();
                destMap.put(dest, cost);
                grHashMap.put(source, destMap);
            }
        }

        Set<Integer> citiesVisited = new HashSet<>();
        HashMap<Integer, Integer> costCities = new HashMap<>(); 
        PriorityQueue<int[]> minCostPQ = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minCostPQ.add(new int[]{0,src});

        while (!minCostPQ.isEmpty()) {
            int[] city = minCostPQ.poll();
            int cst = city[0], c = city[1];

            if (citiesVisited.contains(c)) continue;
            citiesVisited.add(c);

            HashMap<Integer, Integer> destMap = grHashMap.get(c);
            for (int destKey : destMap.keySet()) {
                int costToDest = cst + destMap.get(destKey);
                int[] cityInfo = new int[]{costToDest, destKey};
                minCostPQ.add(cityInfo);
                if (costCities.containsKey(destKey)) {
                    if (costCities.get(destKey) > costToDest) costCities.put(destKey, costToDest);
                } else {
                    costCities.put(destKey, costToDest);
                }
            }

        }

    }
}
