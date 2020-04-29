/**
 * @authour winner
 * @Date 2020/4/26 22:59
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return isSymmetric(p.right, q.left) && isSymmetric(p.left, q.right);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(tree1));
    }
}
