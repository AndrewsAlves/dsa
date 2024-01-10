import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        int noOfFreshOr = 0;
        int noOfRotten = 0;
        Queue<Integer> visited = new ArrayDeque<>();
        HashMap<Integer, int[]> visitedMap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    noOfFreshOr++;
                } else if (grid[i][j] == 2) {
                    noOfRotten++;
                    int index = getIndexFromRowNColumn(grid[i].length, i, j);
                    int[] row_col = {i,j};
                    visitedMap.put(index, row_col);
                    visited.add(index);
                }
            }
        }

        if (noOfRotten == 0) System.out.println(-1);

        int timeTaken = 0;
        int[] noOfRottenCh = {0};
        while (!visited.isEmpty()) {
            int rottedLength = visited.size();
            int rottenTillNow = noOfRottenCh[0];
            while (rottedLength-- != 0) {
                int index2 = visited.poll();
                int[] row_col2 = visitedMap.get(index2);
                bfs(grid, visitedMap, visited, noOfRottenCh, row_col2[0], row_col2[1]);
            }

            if (noOfRottenCh[0] != rottenTillNow)timeTaken++;
        }

        if (noOfRottenCh[0] == noOfFreshOr) {
            return timeTaken-1;
        } else {
            return -1;
        }

    }

    public static void bfs(int[][] grid, HashMap<Integer, int[]> visitedMap, Queue<Integer> visited, int[] noOfRottenCh, int r, int c) {

        int index = getIndexFromRowNColumn(grid[0].length, r, c);

        r = r - 1;
        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] == 1) {
            index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] row_col = {r,c};
                visited.add(index);
                visitedMap.put(index, row_col);
                noOfRottenCh[0]++;
            }
        }

        r = r + 1;
        c = c + 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] == 1) {
            index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] row_col = {r,c};
                visited.add(index);
                visitedMap.put(index, row_col);
                noOfRottenCh[0]++;
            }
        }

        r = r + 1;
        c = c - 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] == 1) {
            index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] row_col = {r,c};
                visited.add(index);
                visitedMap.put(index, row_col);
                noOfRottenCh[0]++;
            }
        }

        r = r - 1;
        c = c - 1;

        if (isInSideTheGraph(grid.length, grid[0].length, r, c) && grid[r][c] == 1) {
            index = getIndexFromRowNColumn(grid[0].length, r, c);
            if (!visitedMap.containsKey(index)) {
                int[] row_col = {r,c};
                visited.add(index);
                visitedMap.put(index, row_col);
                noOfRottenCh[0]++;
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


    public static boolean isAtBorder(int rSize,int cSize,int r,int c) {
        if (r == 0 || c == 0 || r == rSize-1 || c == cSize-1) return true;
        return false;
    }
}
