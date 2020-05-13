/**
 * @authour winner
 * @Date 2020/5/13 22:30
 */
public class Solution {
    int num = 0;
    int result = 0;

    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.right, k);
        System.out.println(root.val);
        num++;
        System.out.println("num" + num);
        if (num == k) {
            result = root.val;
        }
        inOrder(root.left, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println("result:" + solution.kthLargest(root, 2));
    }
}
