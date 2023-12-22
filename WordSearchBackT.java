import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchBackT {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";

        char[] wordChar = word.toCharArray();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        boolean[] isExist = {false};

        for (int r = 0; r < board.length ; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == wordChar[0]) {
                    isWordExists(board, wordChar, hashMap, r, c, 0, isExist);
                }
            }
        }

        if (isExist[0]) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static void isWordExists(char[][] board, char[] wordChar, HashMap<Integer, Integer> hashMap, int r, int c, int index, boolean[] isExist) {
        if (isExist[0]) return;
        if (board[r][c] == wordChar[index]) {

            HashMap<Integer, Integer> wordThereCopy = new HashMap<>();
            wordThereCopy.putAll(hashMap);

            wordThereCopy.put(getIndex(board, r, c), 0);

            if (wordThereCopy.size() == wordChar.length) {
                isExist[0] = true;
                return;
            }

            r = r-1;
            if (indexInsideBoard(board, r, c)) {
                if (board[r][c] == wordChar[index+1] && !wordThereCopy.containsKey(getIndex(board, r, c))) {
                    isWordExists(board, wordChar, wordThereCopy, r, c, index+1, isExist);
                }
            }

            r = r+1;
            c = c+1;

            if (indexInsideBoard(board, r, c)) {
                if (board[r][c] == wordChar[index+1]  && !wordThereCopy.containsKey(getIndex(board, r, c))) {
                    isWordExists(board, wordChar, wordThereCopy, r, c, index+1, isExist);
                }
            }

            r= r+1;
            c = c-1;

            if (indexInsideBoard(board, r, c)) {
                if (board[r][c] == wordChar[index+1]  && !wordThereCopy.containsKey(getIndex(board, r, c))) {
                    isWordExists(board, wordChar, wordThereCopy, r, c, index+1, isExist);
                }
            }

            r = r-1;
            c = c-1;

            if (indexInsideBoard(board, r, c)) {
                if (board[r][c] == wordChar[index+1]  && !wordThereCopy.containsKey(getIndex(board, r, c))) {
                    isWordExists(board, wordChar, wordThereCopy, r, c, index+1, isExist);
                }
            }

        } else {
            return;
        }
    }

    public static int getIndex(char[][] board, int r, int c) {
        return (r * board[0].length) + c;
    }

    public static boolean indexInsideBoard(char[][] board, int r, int c) {
        if (r >=0 && r < board.length && c >= 0 && c < board[r].length) return true;
        return false;
    }
}
