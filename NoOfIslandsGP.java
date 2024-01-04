import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class NoOfIslandsGP {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};

        if (grid.length == 0) return;

        int noOfIslands[] = {0};
        
        Queue<Integer> visitedNodes = new ArrayDeque<>();
        HashMap<Integer, int[]> visitedMap = new HashMap<>();

        for (int i = 0; i< grid.length ; i++) {
            for (int j = 0; j < grid[i].length ;j++) {
                if (grid[i][j] == '0') continue;
                int index = getIndexFromRowNColumn(grid[i].length, i, j);
                int[] rowNCol = {i,j};
                if (!visitedMap.containsKey(index)) {
                    noOfIslands[0]++;
                    visitedNodes.add(index);
                    visitedMap.put(index, rowNCol);
                    traverseIslands(grid, visitedNodes, visitedMap);
                }
            }
        }

        System.out.println(noOfIslands[0]);
    }

    public static void traverseIslands(char[][] grid, Queue<Integer> visitedNodes, HashMap<Integer, int[]> visitedMap) {    
        if (visitedNodes.isEmpty()) return;

        int index = visitedNodes.poll();
        int[] rowNCol = visitedMap.get(index);

        exploreNode(grid, visitedNodes, visitedMap, rowNCol[0], rowNCol[1]);
    }

    public static void exploreNode(char[][] grid, Queue<Integer> visitedNodes, HashMap<Integer, int[]> visitedMap, int r, int c) {
        r = r - 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] != '0') {
            int index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] rowNCol = {r, c};
                visitedNodes.add(index);
                visitedMap.put(index, rowNCol);
            }
            
        }

        r = r + 1;
        c = c + 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c)  && grid[r][c] != '0' ) {
            int index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] rowNCol = {r, c};
                visitedNodes.add(index);
                visitedMap.put(index, rowNCol);
            }
        }

        r = r + 1;
        c = c - 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] != '0') {
            int index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] rowNCol = {r, c};
                visitedNodes.add(index);
                visitedMap.put(index, rowNCol);
            }
        }

        r = r - 1;
        c = c - 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] != '0') {
            int index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] rowNCol = {r, c};
                visitedNodes.add(index);
                visitedMap.put(index, rowNCol);
            }
        }

        traverseIslands(grid, visitedNodes, visitedMap);
    }

    public static boolean isInSideTheGraph(int rSize, int cSize, int r, int c) {
        if (r < 0 || c < 0 || r > rSize-1 || c > cSize-1) return false;
        return true;
    }

    public static int getIndexFromRowNColumn(int cSize, int r, int c) {
        if (r == 0) return c;
        return ((r * cSize) + c) ; 
    }

    public static int[] getRowNColumnFromIndex(int cSize, int index) {
        int[] row_col = new int[2];
        if (index < cSize-1) {
            row_col[1] = index;
            return row_col;
        } else {
            row_col[0] = (int)(index / cSize);
            row_col[1] = index % cSize;
            return row_col;
        }
    }

}
