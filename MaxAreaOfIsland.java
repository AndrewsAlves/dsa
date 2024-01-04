import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        HashMap<Integer, int[]> visitedMap = new HashMap<>();
        Queue<Integer> visited = new ArrayDeque<>();
        int largestIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                int index = getIndexFromRowNColumn(grid[i].length, i, j);
                if (!visitedMap.containsKey(index)) {
                    int islandSize = 0;
                    int[] rowNCol = {i,j};
                    visited.add(index);
                    visitedMap.put(index, rowNCol);
                    while (!visited.isEmpty()) {
                        int index2 = visited.poll();
                        int[] rowNCol2 = visitedMap.get(index2);
                        exploreNode(grid, visited, visitedMap, rowNCol2[0], rowNCol2[1]);
                        islandSize++;
                    }
                    if (largestIsland < islandSize) largestIsland = islandSize;
                }
            }
        }

        System.out.println(largestIsland);
    }

    public static void exploreNode(int[][] grid, Queue<Integer> visitedNodes, HashMap<Integer, int[]> visitedMap, int r, int c) {
        r = r - 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] != 0) {
            int index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] rowNCol = {r, c};
                visitedNodes.add(index);
                visitedMap.put(index, rowNCol);
            }
            
        }

        r = r + 1;
        c = c + 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] != 0 ) {
            int index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] rowNCol = {r, c};
                visitedNodes.add(index);
                visitedMap.put(index, rowNCol);
            }
        }

        r = r + 1;
        c = c - 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] != 0) {
            int index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] rowNCol = {r, c};
                visitedNodes.add(index);
                visitedMap.put(index, rowNCol);
            }
        }

        r = r - 1;
        c = c - 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] != 0) {
            int index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] rowNCol = {r, c};
                visitedNodes.add(index);
                visitedMap.put(index, rowNCol);
            }
        }

    }

    public static boolean isInSideTheGraph(int rSize, int cSize, int r, int c) {
        if (r < 0 || c < 0 || r > rSize-1 || c > cSize-1) return false;
        return true;
    }

    public static int getIndexFromRowNColumn(int cSize, int r, int c) {
        if (r == 0) return c;
        return ((r * cSize) + c) ; 
    }
}
