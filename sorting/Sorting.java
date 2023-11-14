package sorting;
import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        // -1,-5,0,16,75,25,7,81,97
        // 8,6,10,2,0
        // 56,25,41,7,9,0,1,16,2,3
        int[] elements = {8,6,10,2,0};
        elements = selectionSort(elements);
        System.out.println(Arrays.toString(elements));
    }

    public static int[] bubbleSort(int[] elements) {
        boolean isSorted = false;
        while(!isSorted) {
            int flag = 0;
            for(int j = 0; j < elements.length - 1; j++) {
                if (elements[j] > elements[j+1]) {
                    int high = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = high;
                    flag = 1;
                }
            }
            if (flag == 0) {
                isSorted = true;
                break;
            }
        }
        return elements;
    }

    public static int[] selectionSort(int[] elements) {

        for (int i = 0; i < elements.length - 1; i++) {
            int lowest = elements[i];
            int iSwap = 0;
            for (int j = i; j < elements.length; j++) {
                if (elements[j] < lowest) {
                    lowest = elements[j];
                    iSwap = j;
                }
            }

            int swappy = elements[i];
            elements[i] = lowest;
            elements[iSwap] = swappy;
        }
        
        return elements;
    }



    
}
