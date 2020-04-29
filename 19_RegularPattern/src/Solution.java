/**
 * @Description:
 * @CreateDate: 2020/4/26 10:39
 * @Author: wangning
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int rowLen = s.length();
        int colLen = p.length();
        boolean[][] dp = new boolean[rowLen + 1][colLen + 1];
        dp[0][0] = true;

        for (int j = 1; j <= colLen; j++) {
            if (p.charAt(j - 1) == '*' && (j - 2) >= 0 && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= rowLen; i++) {
            for (int j = 1; j <= colLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != '.' && s.charAt(i - 1) != p.charAt(j - 2)) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                            if (i>=2 && s.charAt(i - 2) == s.charAt(i - 1)) {
                                dp[i][j] = dp[i - 1][j];
                            } else {
                                dp[i][j] = dp[i][j - 1] || dp[i][j-2];
                            }
                        } else {
                            dp[i][j] = false;
                        }
                    }
                } else {
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[rowLen][colLen];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isMatch("aa", "a"));
//        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
//        System.out.println(solution.isMatch("aab", "c*a*b"));
//        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
//        System.out.println(solution.isMatch("aaa", "ab*a*c*ab"));
//        System.out.println(solution.isMatch("a", "ab*a*"));
    }
}
