/**
 * @authour winner
 * @Date 2020/5/8 22:56
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        if (p.val < root.val && q.val > root.val) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(root, root.right, root.left).val);
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.left).val);
    }
}
