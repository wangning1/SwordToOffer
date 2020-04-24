import java.util.Arrays;

/**
 * @Description:
 * @CreateDate: 2020/4/24 12:50
 * @Author: wangning
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            //从前往后找到偶数位置
            while (start <= end && nums[start] % 2 != 0) {
                start++;
            }
            //从后找打奇数位置
            while (start <= end && nums[end] % 2 != 1) {
                end--;
            }

            if (start >= end) {
                break;
            }

            //交换数据
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            //交换完之后
            start++;
            end--;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 2, 4};
        System.out.println(Arrays.toString(solution.exchange(nums)));
    }
}
