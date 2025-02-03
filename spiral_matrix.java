import java.util.ArrayList;
import java.util.List;


public class spiral_matrix{


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;  //base case of matrix being empty
        }

        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        int totalElements = matrix.length * matrix[0].length;
        
        //checks if result is less than the total elements, if not we know result is = total elements so we can exit the loop.
        while (result.size() < totalElements) {
            
            //stage 1, traverse the top row from left to right
            for (int i = colStart; i <= colEnd && result.size() < totalElements; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;  //moves down
            
            //stage 2 traverse from right col top to bottom
            for (int i = rowStart; i <= rowEnd && result.size() < totalElements; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;  //moves left

            //stage 3 traverse right to left  on bottom row
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart && result.size() < totalElements; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;  //moves up
            }

            //stage 4 traverse left col from bottom to top 
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart && result.size() < totalElements; i--) {
                    result.add(matrix[i][colStart]);
                }
                colStart++;  //move right
            }
        }
        
        return result;  //returns the elements in matrix spiral order
    }
}
