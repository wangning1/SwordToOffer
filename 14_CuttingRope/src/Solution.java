/**
 * @Description:
 * @CreateDate: 2020/4/23 18:43
 * @Author: wangning
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 1;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(dp[j] * dp[i - j], max);
            }
            dp[i] = max;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(3));
        System.out.println(solution.cuttingRope(4));
        System.out.println(solution.cuttingRope(5));
    }
}
