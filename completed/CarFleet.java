package completed;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class CarFleet {
    public static void main(String[] args) {
        int target = 10;
        int[] position = {3};
        int[] speed = {3};

        System.out.println(carFleet2(target, position, speed));
        System.out.println(" ");
    }

    public static int carFleet2(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> positionMap = new TreeMap<>();
        for (int i = 0; i < position.length ; i++) {
            positionMap.put(position[i], speed[i]);
        }

        List<Integer> keyset = new ArrayList<>(positionMap.descendingKeySet());
        Stack<Float> positionStack = new Stack<>();
        int noOfFleets = 0;
        float time = 0;
        for (int i = 0; i < position.length ; i++) {
            int pos = keyset.get(i);
            time = ((target - pos) / (float)positionMap.get(pos));
            if (i == 0) {
                positionStack.push(time);
                noOfFleets++;
                continue;
            }

            if (time <= positionStack.peek()) {
                time = positionStack.peek();
                positionStack.push(time);
            } else {
                positionStack.push(time);
                noOfFleets++;
            }

        }

        return noOfFleets;
    }
}
