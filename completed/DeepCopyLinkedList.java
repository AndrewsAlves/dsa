package completed;
import java.util.HashMap;

public class DeepCopyLinkedList {
    public static void main(String[] args) {
        
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node head2 = new Node(0);
        HashMap<Node,Node> hashMap = new HashMap<>();
        copyList(head, head2,hashMap);
        setRandom(hashMap, head, head2);
        return head2;
    }

    public static void copyList(Node head, Node head2, HashMap<Node,Node> hashMap) {
        head2.val = head.val;
        head2.next = new Node(0);
        hashMap.put(head, head2);
        if (head.next == null) {
            head2.next = null; 
            return;
        }
        copyList(head.next, head2.next,hashMap);
    }

    public static void setRandom(HashMap<Node,Node> hashMap, Node head, Node head2) {
        if (head == null) return;
        head2.random = hashMap.get(head.random);
        setRandom(hashMap, head.next, head2.next);
    }
}

class Node {
        int val;
        Node next = null;
        Node random = null;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
}

