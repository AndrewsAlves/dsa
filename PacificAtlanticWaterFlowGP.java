import java.util.*;

public class PacificAtlanticWaterFlowGP {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},
                            {3,2,3,4,4},
                            {2,4,5,3,1},
                            {6,7,1,4,5},
                            {5,1,1,2,4}};

        List<List<Integer>> mainList = new ArrayList<>();                    
        for (int r = 0 ; r < heights.length; r++) {
            for (int c = 0; c < heights[r].length; c++) {
                if (canGoToPacificAndAtlantic(heights,new HashSet<Integer>(), r, c, new boolean[2])) {
                    mainList.add(Arrays.asList(r,c));
                }
            }
        }
    }

    public static boolean canGoToPacificAndAtlantic(int[][] heights,Set<Integer> visitedNode, int r, int c, boolean[] oceansFlowed) {

        int prevHeight = heights[r][c];
        visitedNode.add(getIndexFromRowNColumn(heights[0].length, r, c));

        r = r - 1;

        if (!isInSideTheGraph(heights.length, heights[0].length, r, c)) {
            oceansFlowed[0] = true;
        } else if(heights[r][c] <= prevHeight && !visitedNode.contains(getIndexFromRowNColumn(heights[0].length, r, c))) {
            canGoToPacificAndAtlantic(heights,visitedNode, r, c, oceansFlowed);
        }

        r = r + 1;
        c = c + 1;

         if (!isInSideTheGraph(heights.length, heights[0].length, r, c)) {
            oceansFlowed[1] = true;
        } else if(heights[r][c] <= prevHeight && !visitedNode.contains(getIndexFromRowNColumn(heights[0].length, r, c))) {
            canGoToPacificAndAtlantic(heights,visitedNode, r, c, oceansFlowed);
        }

        r = r + 1;
        c = c - 1;

        if (!isInSideTheGraph(heights.length, heights[0].length, r, c)) {
            oceansFlowed[1] = true;
        } else if(heights[r][c] <= prevHeight && !visitedNode.contains(getIndexFromRowNColumn(heights[0].length, r, c))) {
            canGoToPacificAndAtlantic(heights,visitedNode, r, c, oceansFlowed);
        }

        r = r - 1;
        c = c - 1;

         if (!isInSideTheGraph(heights.length, heights[0].length, r, c)) {
            oceansFlowed[0] = true;
        } else if(heights[r][c] <= prevHeight && !visitedNode.contains(getIndexFromRowNColumn(heights[0].length, r, c))) {
            canGoToPacificAndAtlantic(heights,visitedNode, r, c, oceansFlowed);
        }

        if (oceansFlowed[0] && oceansFlowed[1]) return true;
        return false;
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
