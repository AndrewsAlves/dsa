import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeightHeap {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        PriorityQueue<Integer> gameQue = new PriorityQueue<>(stones, Collections.reverseOrder());
        for (int n : stones) gameQue.add(n);
        while (!gameQue.isEmpty()) {
            if (gameQue.size() == 1) break;
            int x = gameQue.poll();
            int y = gameQue.poll();
            if (Math.abs(x-y) != 0) gameQue.add(Math.abs(x-y));
        }
        if (gameQue.isEmpty()) return 0;
        return gameQue.poll();
    }
}
