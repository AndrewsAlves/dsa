package completed;
public class RemoveNthNode {
    
    public static void main(String[] args) {
        int[] nums = {1,2};
        ListNode head = createSingleSinkedList(nums);
        removeNthFromEnd(head, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int[] listLength = {0};
        getLength(head, listLength);

        if (listLength[0] == 1 && n == 1) return null;
        if (listLength[0] == n) return head.next;

        removeNthElement(head, n, listLength);
        print(head);
        System.gc();
        //System.out.println(listLength[0]);
        return head;
    }

    public static void getLength(ListNode node, int[] lenthCount) {
        if (node == null) return;
        lenthCount[0]++;
        getLength(node.next, lenthCount);
    }

    public static void removeNthElement(ListNode node, int element, int[] lenthCount) {
        if (lenthCount[0] == element+1) {
            node.next = node.next.next;
            return;
        } else if (lenthCount[0] == element){
            node = node.next;
            return;
        }else {
            lenthCount[0]--;
            removeNthElement(node.next, element, lenthCount);
        }
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
                if (i == nums.length-1) head.next = null;
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