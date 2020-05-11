import java.util.Arrays;

/**
 * @authour winner
 * @Date 2020/5/10 16:00
 */
public class Solution {
    /**
     * 常规解法
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        long[] uglyNums = new long[n * 3 + 1];
        int startIdx = 0;
        int endIdx = 0;
        uglyNums[0] = 1;
        while (startIdx < n) {
            long currentNum = uglyNums[startIdx++];
            //2倍处理
            boolean moved = moveNum(uglyNums, endIdx, currentNum * 2);
            if (moved) {
                endIdx++;
            }
            //3倍处理
            moved = moveNum(uglyNums, endIdx, currentNum * 3);
            if (moved) {
                endIdx++;
            }
            //5倍处理
            moved = moveNum(uglyNums, endIdx, currentNum * 5);
            if (moved) {
                endIdx++;
            }
        }
        System.out.println(Arrays.toString(uglyNums));
        return (Long.valueOf(uglyNums[startIdx - 1]).intValue());
    }

    private boolean moveNum(long[] uglyNums, int endIdx, long newNum) {
        if (newNum == uglyNums[endIdx]) {
            return false;
        } else if (newNum > uglyNums[endIdx]) {
            uglyNums[endIdx + 1] = newNum;
        } else {
            int idx = endIdx;
            while (uglyNums[idx] > newNum && idx > 0) {
                idx--;
            }
            if (uglyNums[idx] == newNum) {
                return false;
            } else {
                for (; endIdx > idx; endIdx--) {
                    uglyNums[endIdx + 1] = uglyNums[endIdx];
                }
                uglyNums[endIdx + 1] = newNum;
            }
        }
        return true;
    }

    /**
     * 动态规划解法
     * @param n
     * @return
     */
    public int nthUglyNumberWithDp(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumberWithDp(1407));
    }
}
