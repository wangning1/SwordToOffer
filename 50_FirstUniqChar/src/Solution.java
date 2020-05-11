import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @authour winner
 * @Date 2020/5/11 21:49
 */
public class Solution {
    public char firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return ' ';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("abaccdeff"));
    }
}
