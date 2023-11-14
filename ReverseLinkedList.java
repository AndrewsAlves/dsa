

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNodeHead = null; 
        int listLenght = 5;
        for (int i = 0; i < listLenght; i++) {

            listNode.val = i+1;
            listNode.next = new ListNode();
            if (i == listLenght - 1 ) listNode.next = null;
        
            if (i == 0) {
                listNodeHead = listNode;
            }
            listNode = listNode.next;
            
        }

        reverseList(listNodeHead);
    }

    public static void printLnkedList(ListNode listNode) {
        System.out.println(listNode.val);
        if (listNode.next != null) {
            printLnkedList(listNode.next);
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode lastNode = getLastNode(head);
        ListNode headNote = recursiveNodeList(head);
        headNote.next = null;
        printLnkedList(lastNode);

        return lastNode;
    }

    public static ListNode recursiveNodeList(ListNode head) {
        if (head.next == null) {
            return head;
        }

        //System.out.println(head.val);
        ListNode previousNode = recursiveNodeList(head.next);
        previousNode.next = head;

        return head;
    }

    public static ListNode getLastNode(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode node1 = getLastNode(node.next);
        return node1;
    }


    
 // Definition for singly-linked list.
    

}

class ListNode {
      int val;
      ListNode next = null;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}