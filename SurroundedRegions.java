import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},
                          {'X','O','O','X'},
                          {'X','X','O','X'},
                          {'X','O','X','X'}};
        
        Set<Integer> cantFlipSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (isAtBorder(board.length, board[0].length, i, j) && board[i][j] == 'O' && !cantFlipSet.contains(getIndexFromRowNColumn(board[i].length, i, j))) {
                    Set<Integer> visitedNode = new HashSet<>();
                    dfs(board, visitedNode, i, j);
                    cantFlipSet.addAll(visitedNode);
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !cantFlipSet.contains(getIndexFromRowNColumn(board[i].length, i, j))) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board,Set<Integer> visitedNode, int r, int c) {

        visitedNode.add(getIndexFromRowNColumn(board[0].length, r, c));

        r = r - 1;
        if (isInSideTheGraph(board.length, board[0].length, r, c) && board[r][c] == 'O' && !visitedNode.contains(getIndexFromRowNColumn(board[0].length, r, c))) {
           dfs(board,visitedNode, r, c);
        }

        r = r + 1;
        c = c + 1;

        if (isInSideTheGraph(board.length, board[0].length, r, c) && board[r][c] == 'O' && !visitedNode.contains(getIndexFromRowNColumn(board[0].length, r, c))) {
           dfs(board,visitedNode, r, c);
        }

        r = r + 1;
        c = c - 1;

        if (isInSideTheGraph(board.length, board[0].length, r, c) && board[r][c] == 'O' && !visitedNode.contains(getIndexFromRowNColumn(board[0].length, r, c))) {
           dfs(board,visitedNode, r, c);
        }

        r = r - 1;
        c = c - 1;

        if (isInSideTheGraph(board.length, board[0].length, r, c) && board[r][c] == 'O' && !visitedNode.contains(getIndexFromRowNColumn(board[0].length, r, c))) {
           dfs(board,visitedNode, r, c);
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
