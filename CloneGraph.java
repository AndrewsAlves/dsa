/**
 * CloneGraph
 */
import java.util.*;
public class CloneGraph {

    public static void main(String[] args) {
        
        cloneGraph(null, null);
        HashMap<Node, Node> hashMap = new HashMap<>(); 
        for (Node node2 : hashMap.keySet()) {
            Node cloneNode = hashMap.get(node2);
            if (node2.neighbors == null) continue;
            for (Node subNode : node2.neighbors) {
                cloneNode.neighbors.add(hashMap.get(subNode));
            }
        }
    }

    public static Node cloneGraph(Node node, HashMap<Node, Node> hashMap) {
        Node head = new Node(node.val);

        hashMap.put(node, head);
        if (node.neighbors == null) return head;
        for (Node subNode : node.neighbors) {
            if (hashMap.containsKey(subNode)) continue;
            cloneGraph(subNode, hashMap);
        }

        return head;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}