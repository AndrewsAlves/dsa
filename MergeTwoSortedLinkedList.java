import java.util.Random;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {

        ListNode head1 = getRandomNode(4);
        ListNode head2 = getRandomNode(3);
        ListNode tailNodeHead1 = getLastNode(head1);

        // Merge the Liskd List
        tailNodeHead1.next = head2;
        printLnkedList(head1);

        //Sort the list
        ListNode headNode = sortList(head1);
        System.out.println(" FINISED ");
        printLnkedList(headNode);
    }

    private static ListNode getRandomNode(int length) {
        Random rand = new Random();
        ListNode node = new ListNode(rand.nextInt(99));
        ListNode head1 = null;
        for (int i = 0; i < length; i++){

            if (i < length - 1 ) {
                node.next = new ListNode(rand.nextInt(99));
            } else {
                node.next = null;
            }

            if (i == 0) {
                head1 = node;
            }

            node = node.next;
        }

        //printLnkedList(head1);
        return head1;
    }



    public static ListNode getLastNode(ListNode node) {
        if (node.next == null) {
            return node;
        } else {
            ListNode lastNode = getLastNode(node.next);
            return lastNode;
        }
    }

    public static ListNode sortList(ListNode headNode) {

        int lowest = headNode.val;
        ListNode lowNode = headNode;
        ListNode sortedNode = null;
        ListNode sortedHeaNode = null;
        ListNode currentNode = headNode;

        while (currentNode != null) {

            ListNode compareNode = currentNode;
            while (compareNode != null) {
                if (compareNode.val < lowest) {
                lowest = compareNode.val;
                lowNode = compareNode;
                }
                compareNode = compareNode.next;
                //System.out.println(lowNode.val);
            }

            if (sortedNode == null) {
                sortedNode = lowNode;
                sortedHeaNode = lowNode;
            } else {
                sortedNode.next = lowNode;
                sortedNode = sortedNode.next;
            }
            
            currentNode = deleteNode(currentNode, lowNode);
            if (currentNode != null) {
                lowNode = currentNode;
                lowest = currentNode.val;   
            }
            //System.out.println(lowNode.val);
        }

        //for ()
        return sortedHeaNode;
    }

    public static ListNode deleteNode(ListNode headNode, ListNode node) {
        ListNode currentNode = headNode;
        while (currentNode != null) {

            if (node == headNode) {
                return headNode.next;
            }

            if (node == currentNode.next) {
                currentNode.next = node.next;
            }

            currentNode = currentNode.next;
        }

        System.out.println(" ");
        printLnkedList(headNode);
        return headNode;
    }

    public static void printLnkedList(ListNode listNode) {
        System.out.println(listNode.val);
        if (listNode.next != null) {
            printLnkedList(listNode.next);
        }
    }

}

class ListNode {
      int val;
      ListNode next = null;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}