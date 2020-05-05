import java.util.*;

/**
 * @authour winner
 * @Date 2020/5/5 10:54
 */
public class Solution {
    public String[] permutation(String s) {
        if (s == null) {
            return null;
        }
        Set<String> resultSet = new HashSet<>();

        dfs(s, 0, "", resultSet);
        String[] result = new String[resultSet.size()];
        int i = 0;
        for (String str : resultSet) {
            result[i++] = str;
        }
        Arrays.sort(result);
        return result;
    }

    private void dfs(String s, int level, String res, Set<String> resultSet) {
        if (level == s.length()) {
            resultSet.add(res);
            return;
        }

        String tmp = s;
        //去除掉已经加过的字符
        for (int i = 0; i < res.length(); i++) {
            tmp = tmp.replaceFirst(res.charAt(i) + "", "");
        }

        for (char c : tmp.toCharArray()) {
            dfs(s, level + 1, res + c, resultSet);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.permutation(s)));
    }
}
