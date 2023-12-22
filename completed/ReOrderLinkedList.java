package completed;
import java.util.List;

public class ReOrderLinkedList {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        ListNode head = createSingleSinkedList(nums);
        //print(createSingleSinkedList(nums));
        //print(reorderList(createSingleSinkedList(nums)));
        //print(removeLast(head));
        //print(removeLast(head));
       // print(removeLast(head));
        print(reorderList(head));
    }

    public static ListNode reorderList(ListNode head) {

        ListNode node = head;
        while (node != null) {
            if (node.next == null) break;
            //System.out.println(node.val);
            ListNode nextNode = node.next;
            ListNode lastNode = removeLast(head);
            if (nextNode == lastNode) {
                node.next = nextNode;
                break;
            }
            node.next = lastNode;
            node.next.next = nextNode;
            //System.out.println(node.next.val);
            node = node.next.next;
        }

        return head;
    }

    public static ListNode removeLast(ListNode node) {


        if (node.next.next == null) {
            ListNode lastNode = node.next;
            node.next = null;
            return lastNode;
        }

        return removeLast(node.next);
    }

    public static void print(ListNode head) {
        if (head == null) return;
        System.out.println(head.val);
        print(head.next);
    }

    public static ListNode createSingleSinkedList(int[] nums) {

        ListNode head = null;
        ListNode node = null;
        for (int i = 0 ; i < nums.length ; i++) {
            if (head == null) {
                head = new ListNode();
                head.val = nums[i];
                head.next = new ListNode();
                node = head.next;
            } else {
                node.val = nums[i];
                node.next = new ListNode();
                if (i == nums.length-1) node.next = null;
                node = node.next;
            }
        }

        return head;
    }
}

class ListNode {
        int val;
        ListNode next = null;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
