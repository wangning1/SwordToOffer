/**
 * @authour winner
 * @Date 2020/4/23 22:33
 */
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(9));
        double d1 = 2.3000d;
        double d2 = 2.300d;
        System.out.println(d1 == d2);
    }
}
