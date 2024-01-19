import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.List;;
public class GasStationGreedy {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int[] diff = new int[gas.length];
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length ; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            diff[i] = gas[i] - cost[i];
        }

        if (totalCost > totalGas) return -1;

        int total = 0;
        int res = 0;
        for (int i = 0; i < diff.length ; i++) {
            total += diff[i];
            if (total < 0){
                total = 0;
                res = i+1;
            }
        }

        return res;
        /*TreeMap<Integer, List<Integer>> bestStations = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            if (diff >= 0) {
               if (bestStations.containsKey(diff)) {
                    bestStations.get(diff).add(i);
               } else {
                    List<Integer> stations = new ArrayList<>();
                    stations.add(i);
                    bestStations.put(diff, stations);
               }
            }
        }

        for (int key : bestStations.keySet()) {
            for (int stations : bestStations.get(key)) {
                int circuiteStation = isCircuitPossible(gas, cost, stations);
                if (circuiteStation != -1) {
                    //System.out.println(circuiteStation);
                    return circuiteStation;
                }
            }
        }*/

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            if (diff >= 0) {
                int circuiteStation = isCircuitPossible(gas, cost, i);
                if (circuiteStation != -1) {
                    //System.out.println(circuiteStation);
                    return circuiteStation;
                }
            }
        }

        return -1;
    }
 
    public static int isCircuitPossible(int[] gas, int[] cost, int currentStation) {
        int station = currentStation;
        int gasLeft = 0;
        while (true) {
            gasLeft += gas[station];
            if (cost[station] > gasLeft) {
                return -1;
            } 

            gasLeft -= cost[station];
            station++;
            if (station > gas.length-1) station -= gas.length;
            if (station == currentStation) return currentStation;
        }
    }
}
