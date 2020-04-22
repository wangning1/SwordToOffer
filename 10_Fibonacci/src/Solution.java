/**
 * @Description:
 * @CreateDate: 2020/4/22 18:16
 * @Author: wangning
 */
public class Solution {

    /**
     * 递归求解
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] fArr = new int[n + 1];
        fArr[0] = 0;
        fArr[1] = 1;
        for (int i = 2; i <= n; i++) {
            fArr[i] = (fArr[i - 1] + fArr[i - 2]) % 1000000007;
        }
        return fArr[n] ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(48));
//        1134903170
//        134903163
        System.out.println(solution.fib2(48));
    }
}
