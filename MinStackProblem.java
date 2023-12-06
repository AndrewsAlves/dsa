import java.util.LinkedList;
import java.util.TreeMap;

public class MinStackProblem {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.getMin(); // return -2
    }
}

class MinStack {
    
    LinkedList<Integer> linkedList;
    TreeMap<Integer,Integer> treeMap;

    public MinStack() {
        linkedList = new LinkedList<>();
        treeMap = new TreeMap<>();
    }
    
    public void push(int val) {
        linkedList.add(val);
        if (treeMap.containsKey(val)) {
            treeMap.put(val, treeMap.get(val) + 1);
        } else {
            treeMap.put(val, 1);
        }
    }
    
    public void pop() {
        int i = linkedList.removeLast();
        int cu = treeMap.get(i);
        if (cu > 1) treeMap.put(i, cu - 1);
        else treeMap.remove(i);
    }
    
    public int top() {
        System.out.println(linkedList.getLast());
        return linkedList.getLast();
    }
    
    public int getMin() {
        System.out.println(treeMap.firstKey());
        return treeMap.firstKey();
    }
}