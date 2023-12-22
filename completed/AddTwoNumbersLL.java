package completed;
import java.math.BigInteger;

public class AddTwoNumbersLL {
    public static void main(String[] args) {
        int[] nums = {9};
        int[] nums2 = {1,9,9,9,9,9,9,9,9,9};
        ListNode l1 = createSingleSinkedList(nums);
        ListNode l2 = createSingleSinkedList(nums2);
        String[] s1 = {""}, s2 = {""};
        getIntegers(l1, l2, s1, s2);
        
        String total = (new BigInteger(s1[0]).add(new BigInteger(s2[0]))).toString();
        char[] charTotal = total.toCharArray();
        //System.out.println(total);

        ListNode head = null;
        ListNode node = null;
        for (int i = charTotal.length - 1; i >= 0 ; i--) {
            if (head == null) {
                head = new ListNode();
                head.val = Character.getNumericValue(charTotal[i]);
                head.next = new ListNode();
                if (i == 0) head.next = null;
                node = head.next;
            } else {
                node.val = Character.getNumericValue(charTotal[i]);
                node.next = new ListNode();
                if (i == 0) node.next = null;
                node = node.next;
            }
        }

        print(head);
    }

    public static void getIntegers(ListNode l1, ListNode l2, String[] s1, String[] s2) {
        if (l1 == null && l2 == null) return;
        if (l1 == null) getIntegers(null, l2.next, s1, s2);
        else if (l2 == null) getIntegers(l1.next, null, s1, s2);
        else getIntegers(l1.next, l2.next, s1, s2);
        if (l1 != null) s1[0] = s1[0] +  "" + l1.val;
        if (l2 != null) s2[0] = s2[0] + "" + l2.val;
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
class ListNode {
        int val;
        ListNode next = null;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}