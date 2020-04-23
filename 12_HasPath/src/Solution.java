import java.util.ArrayList;
import java.util.List;

/**
 * @authour winner
 * @Date 2020/4/22 22:51
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                existPath(i, j, board, visited, 0, word, result);
                if (!result.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    void existPath(int i, int j, char[][] board, boolean[][] visited, int level, String word, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (!result.isEmpty()) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        if (word.charAt(level) != board[i][j]) {
            return;
        }

        if (level >= word.length() - 1) {
            result.add(word);
            return;
        }

        visited[i][j] = true;
        existPath(i + 1, j, board, visited, level + 1, word, result);
        existPath(i - 1, j, board, visited, level + 1, word, result);
        existPath(i, j + 1, board, visited, level + 1, word, result);
        existPath(i, j - 1, board, visited, level + 1, word, result);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'a', 'b'}

        };

        System.out.println(solution.exist(board, "ba"));

    }
}
