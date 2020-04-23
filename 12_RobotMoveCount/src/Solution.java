import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @CreateDate: 2020/4/23 12:43
 * @Author: wangning
 */
public class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        caculateCore(0, 0, m, n, k, visited, map);
        return map.get(0);
    }

    void caculateCore(int i, int j, int m, int n, int k, boolean[][] visited, Map<Integer, Integer> map) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        if (caculateDigitSum(i) + caculateDigitSum(j) > k) {
            return;
        } else {
           map.put(0, map.get(0) + 1);
        }

        visited[i][j] = true;
        caculateCore(i + 1, j, m, n, k, visited, map);
        caculateCore(i - 1, j, m, n, k, visited, map);
        caculateCore(i, j + 1, m, n, k, visited, map);
        caculateCore(i, j - 1, m, n, k, visited, map);
//        visited[i][j] = false;
    }

    private int caculateDigitSum(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num = num / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
        System.out.println(solution.movingCount(3, 1, 0));
        System.out.println(solution.movingCount(3, 2, 17));
    }
}
