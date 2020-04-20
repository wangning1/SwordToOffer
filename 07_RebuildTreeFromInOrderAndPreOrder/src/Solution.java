import java.util.HashMap;
import java.util.Map;

/**
 * @authour winner
 * @Date 2020/4/20 22:05
 */
public class Solution {
    int[] preOrder;
    int[] inOrder;
    Map<Integer, Integer> preOrderValueIndexMap = new HashMap<>();
    //映射值与中序索引的对应关系
    Map<Integer, Integer> inOrderValueIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        this.inOrder = inorder;
        this.preOrder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inOrderValueIndexMap.put(inorder[i], i);
        }
        for (int i = 0; i < preorder.length; i++) {
            preOrderValueIndexMap.put(preorder[i], i);
        }
        return buildTreeCore(0, inorder.length - 1, preorder[0]);
    }


    TreeNode buildTreeCore(int leftIndex, int rightIndex, int root) {
        TreeNode node = new TreeNode(root);
        if (rightIndex == leftIndex) {
            node.left = null;
            node.right = null;
        } else {
            int index = inOrderValueIndexMap.get(root);
            if (leftIndex == index) {
                node.left = null;
            } else {
                //找左子树根 根据中序中左子树的元素 找到前序最小的索引对应的值
                int leftRoot = inOrder[leftIndex];
                int leftRootMinIndex = preOrderValueIndexMap.get(leftRoot);
                for (int i = leftIndex; i <= index - 1; i++) {
                    if (leftRootMinIndex > preOrderValueIndexMap.get(inOrder[i])) {
                        leftRoot = inOrder[i];
                        leftRootMinIndex = i;
                    }
                }
                node.left = buildTreeCore(leftIndex, index - 1, leftRoot);
            }

            if (rightIndex == index) {
                node.right = null;
            } else {
                //找右子树的根
                int rightRoot = inOrder[index + 1];
                int rightRootMinIndex = preOrderValueIndexMap.get(rightRoot);
                for (int i = index + 1; i <= rightIndex; i++) {
                    if (rightRootMinIndex > preOrderValueIndexMap.get(inOrder[i])) {
                        rightRoot = inOrder[i];
                        rightRootMinIndex = i;
                    }
                }
                node.right = buildTreeCore(index + 1, rightIndex, rightRoot);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] preorder = new int[]{3, 9, 20, 15, 7};
//        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] preorder = new int[]{4, 3, 2, 1};
        int[] inorder = new int[]{1, 2, 3, 4};
        TreeNode root = solution.buildTree(preorder, inorder);
        solution.preOrderPrint(root);
    }

    void preOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "->");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }
}
