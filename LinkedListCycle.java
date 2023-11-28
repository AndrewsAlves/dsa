import java.util.HashMap;

public class LinkedListCycle {

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;

        ListNode currentNode = head;
        HashMap<Integer, ListNode> nodes = new HashMap<Integer, ListNode>();
        
        int i = 0;
        while (currentNode != null) {

            if (nodes.containsValue(currentNode)) {
                System.gc();
                return true;
            }
            
            nodes.put(i, currentNode);

            if (currentNode.next == null) {
                System.gc();
                return false;
            }

            currentNode = currentNode.next;
            i++;
        }

        //for ()
        return false;
    }
}