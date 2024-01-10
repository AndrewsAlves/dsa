import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RedundantConnection {
    public static void main(String[] args) {
        int[][]edges = {{1,2},{1,3},{2,3}};

        HashMap<Integer,Set<Integer>> graphMap = new HashMap<>();
        int node, nodeTemp;
        int edge;
        for (int i = 0; i < edges.length; i++) {
            node = edges[i][0];
            edge = edges[i][1];
            if (!graphMap.containsKey(node)) {
                Set<Integer> edgeSet = new HashSet<>();
                edgeSet.add(edge);
                graphMap.put(node, edgeSet);
            } else {
                Set<Integer> edgeSet = graphMap.get(node);
                edgeSet.add(edge);
            }
            nodeTemp = node;
            node = edge;
            edge = nodeTemp;
            if (!graphMap.containsKey(node)) {
                Set<Integer> edgeSet = new HashSet<>();
                edgeSet.add(edge);
                graphMap.put(node, edgeSet);
            } else {
                Set<Integer> edgeSet = graphMap.get(node);
                edgeSet.add(edge);
            }
        }

        Set<Integer> nodesHavingCycle = new LinkedHashSet<>();
        for (int graphNode : graphMap.keySet()) {
            LinkedHashSet<Integer> visitedNodes = new LinkedHashSet<>();
            LinkedHashSet<Integer> visitedNodesreturn = findCycle(graphNode, -1, graphMap, visitedNodes);
            if (visitedNodesreturn != null) {
                nodesHavingCycle.addAll(visitedNodesreturn);
                break;
            }
        }

        for (int i = edges.length-1; i >= 0; i--) {
            node = edges[i][0];
            edge = edges[i][1];
            if (nodesHavingCycle.contains(node) && nodesHavingCycle.contains(edge)) {
                return edges[i];
            }
        }
    }

    public static LinkedHashSet<Integer> findCycle(int node,int parentNode, HashMap<Integer,Set<Integer>> graphMap, LinkedHashSet<Integer> visitedNodes) {
        if (visitedNodes.contains(node)) {
            int nodes = visitedNodes.getFirst();
            while (nodes != node) {
                visitedNodes.remove(nodes);
                nodes = visitedNodes.getFirst();
            }
            return visitedNodes;
        }

        LinkedHashSet<Integer> visitedNodesCopy = new LinkedHashSet<>(visitedNodes);
        visitedNodesCopy.add(node);

        Set<Integer> edgeSet = graphMap.get(node);
        for (int edge : edgeSet) {
            if (edge == parentNode) continue;
            LinkedHashSet<Integer> visitedNodesreturn = findCycle(edge,node, graphMap, visitedNodesCopy);
            if (visitedNodesreturn != null) {
                return visitedNodesreturn;
            }
        }

        return null;
    }
}
