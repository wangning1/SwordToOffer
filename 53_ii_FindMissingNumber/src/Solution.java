/**
 * @authour winner
 * @Date 2020/5/12 23:36
 */
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == mid) {
                start = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return end + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2,4,5};
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(nums));
    }
}
