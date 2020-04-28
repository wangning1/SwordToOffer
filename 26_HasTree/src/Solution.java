/**
 * @authour winner
 * @Date 2020/4/26 22:12
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;

        if (A != null && B != null) {
            if (A.val == B.val) {
                result = hasSubTree(A, B);
            }
            if (!result) {
                result = isSubStructure(A.left, B);
            }

            if (!result) {
                result = isSubStructure(A.right, B);
            }
        }

        return result;
    }

    public boolean hasSubTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }
        return hasSubTree(A.left, B.left) && hasSubTree(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(5);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);

        TreeNode tree2 = new TreeNode(4);
//        tree2.left = new TreeNode(2);

        Solution solution = new Solution();
        System.out.println(solution.isSubStructure(tree1, tree2));
    }
}
