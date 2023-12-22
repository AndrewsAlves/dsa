package Utils;

public class ListNode {
    int val;
        ListNode next = null;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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


