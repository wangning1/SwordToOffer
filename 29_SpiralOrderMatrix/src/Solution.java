import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @CreateDate: 2020/4/28 12:50
 * @Author: wangning
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        addMatrixItem(matrix, result, 0, colLen - 1, 0);
        int[] spiralNum = new int[rowLen * colLen];
        int i = 0;
        result = result.subList(0, rowLen * colLen);
        for (Integer num : result) {
            spiralNum[i] = num;
            i++;
        }
        return spiralNum;
    }

    private void addMatrixItem(int[][] matrix, List<Integer> result, int startx, int endX, int level) {
        //终止条件
        if (startx > endX) {
            return;
        }
        if (level >= matrix.length) {
            return;
        }
        //从左向右
        for (int i = startx; i <= endX; i++) {
            result.add(matrix[level][i]);
        }
        //从上到下
        for (int i = level + 1; i < matrix.length - level; i++) {
            result.add(matrix[i][endX]);
        }
        //从右往左
        for (int i = endX - 1; i >= startx; i--) {
            result.add(matrix[matrix.length - level - 1][i]);
        }
        //从下往上

        for (int i = matrix.length - level - 2; i >= level + 1; i--) {
            result.add(matrix[i][startx]);
        }
        //内一层
        addMatrixItem(matrix, result, startx + 1, endX - 1, level + 1);
    }

    public static void main(String[] args) {
        int[][] martix = new int[][]{
                {1}, {2}, {3}, {4}
        };

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.spiralOrder(martix)));
    }
}
