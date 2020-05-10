import java.util.HashMap;
import java.util.Map;

/**
 * @authour winner
 * @Date 2020/5/10 10:52
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> charOccurIndex = new HashMap<>();
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charOccurIndex.containsKey(c)) {
                dp[i + 1] = i - charOccurIndex.get(c) > dp[i] ? dp[i] + 1 : i - charOccurIndex.get(c);
            } else {
                dp[i + 1] = dp[i] + 1;
            }
            charOccurIndex.put(c, i);
            if (dp[i + 1] > result) {
                result = dp[i + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
