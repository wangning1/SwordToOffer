import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @CreateDate: 2020/4/30 13:57
 * @Author: wangning
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, 0, map);
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private  void dfs(TreeNode node, Integer level, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }
        List<Integer> levelList;
        if (map.get(level) == null) {
            levelList = new ArrayList<>();
            map.put(level, levelList);
        } else {
            levelList = map.get(level);
        }

        levelList.add(node.val);
        dfs(node.left, level + 1, map);
        dfs(node.right, level + 1, map);
    }
}
