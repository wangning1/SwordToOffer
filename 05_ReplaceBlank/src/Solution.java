/**
 * @authour winner
 * @Date 2020/4/19 9:04
 */
public class Solution {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "20%");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("We are happy."));
    }
}
