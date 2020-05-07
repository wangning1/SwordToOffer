/**
 * @authour winner
 * @Date 2020/5/7 22:07
 */
public class Solution {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowsLen = grid.length;
        int colsLen = grid[0].length;
        int[][] dp = new int[rowsLen][colsLen];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < rowsLen; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int j = 1; j < colsLen; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < rowsLen; i++) {
            for (int j = 1; j < colsLen; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rowsLen - 1][colsLen - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
//        int[][] grid = new int[][]{
//                {1, 2, 5},
//                {3, 2, 1}
//        };

        Solution solution = new Solution();
        System.out.println(solution.maxValue(grid));
    }
}
