import java.util.*;;
public class FindMedianHard {
    
}

class MedianFinder {

    List<Integer> numsList;
    public MedianFinder() {
        numsList = new LinkedList<>();
    }
    
    public void addNum(int num) {
        if (numsList.isEmpty()) numsList.add(num);

        if (num <= numsList.get(0)) {
            numsList.add(0, num);
            return;
        }

        if (num >= numsList.get(numsList.size()-1)) {
            numsList.add(num);
            return;
        }

        for (int i = 1; i < numsList.size()-1; i++) {
            if (num >= numsList.get(i-1) && num <= numsList.get(i)){
                numsList.add(i,num);
                break;
            }
        }
    }

    public double findMedian() {
        if (numsList.size() % 2 == 0){
            int middle = numsList.size() / 2;
            return (double)((numsList.get(middle-1) + numsList.get(middle)) / 2.0);
        } else {
            int middle = numsList.size() / 2;
            return (double)numsList.get(middle);
        }
    }
}
