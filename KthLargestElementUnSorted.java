import java.util.PriorityQueue;

public class KthLargestElementUnSorted {
    public static void main(String[] args) {
        
        int nums[] = {3,2,1,5,6,4};
        int k = 2;
        PriorityQueue<Integer> heapQ = new PriorityQueue<>();
        int th  = 0;
        for (int n : nums) {
           th = insert(heapQ, k, n);
        }

        System.out.println(th);
    }

    public static int insert(PriorityQueue<Integer> heapQ, int k, int element) {
        heapQ.add(element);
        if (heapQ.size() > k)heapQ.poll();
        return heapQ.peek();
    }
}
