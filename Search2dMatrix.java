public class Search2dMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,60}};
        int target = 13;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length - 1] == target) return true;
            if (matrix[i][matrix[i].length - 1] > target) {
                for (int j = 0; j < matrix[i].length ; j++) {
                    if (matrix[i][j] == target) return true;
                }
            }
        }
        return false;
    }
}
