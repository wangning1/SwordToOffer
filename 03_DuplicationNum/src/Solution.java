import java.util.Arrays;

/**
 * @authour winner
 * @Date 2020/4/18 14:43
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Arrays.parallelSort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
