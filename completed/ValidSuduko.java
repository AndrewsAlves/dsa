package completed;
import java.util.HashMap;

public class ValidSuduko {
    public static void main(String[] args) {

        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                         ,{'6','.','.','1','9','5','.','.','.'}
                         ,{'.','9','8','.','.','.','.','6','.'}
                         ,{'8','.','.','.','6','.','.','.','3'}
                         ,{'4','.','.','8','.','3','.','.','1'}
                         ,{'7','.','.','.','2','.','.','.','6'}
                         ,{'.','6','.','.','.','.','2','8','.'}
                         ,{'.','.','.','4','1','9','.','.','5'}
                         ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSuduko(board));
    }

    public static boolean isValidSuduko(char[][] board) {
        for (char[] row : board) {
            HashMap<Character,Character> hashmap = new HashMap<>();
            for (char i : row) {
                if (i == '.') continue;
                if (Character.getNumericValue(i) > 9 || Character.getNumericValue(i) < 0) return false;
                if (hashmap.containsValue(i)) return false;
                hashmap.put(i, i);
            }
        }
        
        for (int col = 0; col < board[0].length ; col++) {
            HashMap<Character,Character> hashmap = new HashMap<>();
            for (int r = 0; r < board.length; r++) {
                char i = board[r][col];
                if (i == '.') continue;
                if (Character.getNumericValue(i) > 9 || Character.getNumericValue(i) < 0) return false;
                if (hashmap.containsValue(i)) return false;
                hashmap.put(i, i);
            }
        }

        for (int subBox = 0; subBox < board[0].length; subBox++) {
            int r = 0;
            int col = 0;
            if (subBox >= 3 && subBox <=5) {
                r = 3;
            } else if (subBox >= 6 && subBox <=8) {
                r = 6;
            }

            if (subBox == 1 || subBox == 4 || subBox == 7) {
                col = 3;
            }

            if (subBox == 2 || subBox == 5 || subBox == 8) {
                col = 6;
            }

            //System.out.println(" ");
            int subCol = col; 
            HashMap<Character,Character> hashmap = new HashMap<>();
            for (int i = 0; i < 9 ;i++) {
                if (i == 3 || i == 6) {
                    r++;
                    subCol = col;
                }

                char rc = board[r][subCol];
                //System.out.print("(" + r + ", " + subCol + ")");
                //System.out.print(rc + " ");
                subCol++;
                if (rc == '.') continue;
                if (Character.getNumericValue(rc) > 9 || Character.getNumericValue(rc) < 0) return false;
                if (hashmap.containsValue(rc)) return false;
                hashmap.put(rc, rc);
                
            }
        }

        return true;
    }
}
