/**
 * @authour winner
 * @Date 2020/4/18 14:02
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                row++;
                if (row >= matrix.length) {
                    return false;
                }
            }
            if (matrix[row][col] > target) {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] martix = new int[][]{

        };

        Solution solution = new Solution();
        System.out.println(solution.findNumberIn2DArray(martix, 5));
        System.out.println(solution.findNumberIn2DArray(martix, 20));
        System.out.println(solution.findNumberIn2DArray(martix, 30));
        System.out.println(solution.findNumberIn2DArray(martix, 31));
        System.out.println(solution.findNumberIn2DArray(martix, 1));
    }
}
