/**
 * @authour winner
 * @Date 2020/4/26 22:40
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            root.left = mirrorTree(root.left);
        }

        if (root.right != null) {
            root.right = mirrorTree(root.right);
        }

        return root;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + "->");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(5);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);

        Solution solution = new Solution();
        solution.inOrder(tree1);
        System.out.println();

        solution.inOrder(solution.mirrorTree(tree1));
    }
}
