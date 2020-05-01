import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:
 * @CreateDate: 2020/4/30 14:21
 * @Author: wangning
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        oddStack.add(root);
        int level = 0;
        while (!oddStack.empty() || !evenStack.empty()) {
            List<Integer> list = new ArrayList<>();
            if (level % 2 == 0) {
                int size = oddStack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = oddStack.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        evenStack.add(node.left);
                    }
                    if (node.right != null) {
                        evenStack.add(node.right);
                    }
                }
            } else {
                int size = evenStack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = evenStack.pop();
                    list.add(node.val);
                    if (node.right != null) {
                        oddStack.add(node.right);
                    }
                    if (node.left != null) {
                        oddStack.add(node.left);
                    }
                }
            }
            result.add(list);
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();

        System.out.println(solution.levelOrder(root));

    }
}
