import java.util.Arrays;

public class KthLargestElementHeap {
    public static void main(String[] args) {
        int[] nums = {};
        KthLargest kthLargest = new KthLargest(1, nums);
        System.out.println(kthLargest.add(-1)); // return -3
        System.out.println(kthLargest.add(1));   // return 5
        System.out.println(kthLargest.add(-2)); // return 5
        System.out.println(kthLargest.add(0));  // return 8
        System.out.println(kthLargest.add(4));  // return 8
    }
}

class KthLargest {

    //Max heap
    int capacity = 10100;
    int heapSize = 0;
    int[] heap = new int[capacity];
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        if (heapSize == 0) {
            heap[0] = val;
            heapSize++;
            return heap[0];
        }

        heap[heapSize] = val;
        int childI = heapSize;
        int parentI = ((childI+1)/2)-1; 
        while (childI > 0 && heap[parentI] > heap[childI]) {
            int temp = heap[parentI];
            heap[parentI] = heap[childI];
            heap[childI] = temp; 
            childI = parentI;
            parentI = ((childI+1)/2)-1; 
        }
        heapSize++;

        if (heapSize > k) poll();

        /*for (int i = 0; i < heapSize ; i++) {
            System.out.print(heap[i]);
        }
        System.out.println("");*/

        return heap[0];
    }

    public void poll() {
        if (heapSize == 0) return;
        // delete root to get Max value
        heap[0] = heap[heapSize-1];
        heapSize--;

        int parentI = 0;
        int childI = 0;
        while (childI < heapSize-1) {
            int leftC = (2*parentI)+1;
            int rightC = (2*parentI)+2;
            
            if (leftC < heapSize && rightC < heapSize) {
                if (heap[leftC] < heap[rightC]) childI = leftC;
                else childI = rightC;
            } else if (leftC < heapSize){
                childI = leftC;
            } else break;

            if (heap[parentI] > heap[childI]) {
                int temp = heap[parentI];
                heap[parentI] = heap[childI];
                heap[childI] = temp;
                parentI = childI;
            } else {
                break;
            }
        }

    }
}
