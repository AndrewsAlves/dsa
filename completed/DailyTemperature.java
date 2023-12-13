package completed;
import java.util.Stack;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temprature = {73,74,75,71,69,72,76,73};
        print(dailyTemperature(temprature));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        TreeMap<Integer, List<Integer>> tempMaps = new TreeMap<>();

        for (int i = 0; i < temperatures.length ; i++) {
            if (tempMaps.containsKey(temperatures[i])) {
                List<Integer> indexes = tempMaps.get(temperatures[i]);
                indexes.add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                tempMaps.put(temperatures[i], indexes);
            }
        }

        for (int i = 0; i < temperatures.length ; i++) {
            int temp = temperatures[i];
            int daysWentBy = 0;

            for (int t = temp + 1; t <= 100; t++) {
                if (tempMaps.containsKey(t)) {
                    List<Integer> indexes = tempMaps.get(t);
                    for (int index : indexes) {
                        if (index > i){
                            if (daysWentBy > index - i || daysWentBy == 0) daysWentBy = index - i;
                        }
                    }
                }
            }

            days[i] = daysWentBy;
        }
        
        return days;
    } 

    public static int[] dailyTemperature(int[] temperatures) {
        int[] days = new int[temperatures.length];

        for (int i = 0; i < temperatures.length ; i++) {
            int temp = temperatures[i];

            int k = temperatures.length - 1;
            for (int j = i; j <= k; j++) {

                if (temperatures[j] > temp) {
                    days[i] = j - i;
                    break;
                }

                if (temperatures[k] > temp) {
                    days[i] = k - i;
                }

                k--;
            }

        }
        
        return days;
    }

    public static void print(int[] output) {
        for(int i : output) {
            System.out.print(i + " ");
        }
    }
}
