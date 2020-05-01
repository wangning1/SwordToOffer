/**
 * @authour winner
 * @Date 2020/5/1 10:06
 */
public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return true;
        }

        return verfiy(postorder, 0, postorder.length - 1);
    }

    private boolean verfiy(int[] postorder, int start, int rootIndex) {
        if (start >= rootIndex) {
            return true;
        }
        int mid = rootIndex;
        for (; mid >= start; mid--) {
            if (postorder[mid] < postorder[rootIndex]) {
                break;
            }
        }

        for (int i = start; i <= mid; i++) {
            if (postorder[i] > postorder[rootIndex]) {
                return false;
            }
        }

        return verfiy(postorder, start, mid) && verfiy(postorder, mid + 1, rootIndex - 1);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, 2, 6, 5};
//        int[] nums = new int[]{4, 8, 6, 12, 16, 14, 10};
        int[] nums = new int[]{1, 2, 5, 10, 6, 9, 4, 3};
        Solution solution = new Solution();
        System.out.println(solution.verifyPostorder(nums));
        ;
    }
}
