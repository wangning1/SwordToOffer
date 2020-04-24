import java.util.Arrays;

/**
 * @Description:
 * @CreateDate: 2020/4/24 11:52
 * @Author: wangning
 */
public class Solution {
    public int[] printNumbers(int n) {
        int num = 1;
        while (n-- != 0) {
            num *= 10;
        }
        int[] result = new int[num - 1];
        for (int i = 1; i < num; i++) {
            result[i - 1] = i;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.printNumbers(2)));;
    }
}
