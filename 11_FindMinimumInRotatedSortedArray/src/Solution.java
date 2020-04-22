/**
 * @authour winner
 * @Date 2020/4/22 22:13
 */
public class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5};
        Solution solution = new Solution();
        System.out.println(solution.findMin(nums));
    }
}
