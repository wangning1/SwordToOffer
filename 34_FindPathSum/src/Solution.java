import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @authour winner
 * @Date 2020/5/1 11:30
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        findPath(root, sum, 0, new ArrayList<>(), result);
        return result;
    }

    private void findPath(TreeNode node, int sum, int caculated, List<Integer> sumList, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        List<Integer> list = new ArrayList<>(sumList);
        list.add(node.val);
        if (caculated + node.val == sum && node.left == null && node.right == null) {
            result.add(list);
            return;
        }
        if (node.left != null) {
            findPath(node.left, sum, caculated + node.val, list, result);
        }
        if (node.right != null) {
            findPath(node.right, sum, caculated + node.val, list, result);
        }

    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right = new TreeNode(8);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);

        Solution solution = new Solution();
        System.out.println(solution.pathSum(root, -1));
    }
}
