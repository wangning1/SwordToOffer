import java.util.Stack;

/**
 * @authour winner
 * @Date 2020/4/29 22:32
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popedI = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] != popped[popedI]) {
                while (!stack.empty() && stack.peek() == popped[popedI]) {
                    stack.pop();
                    popedI++;
                }
                stack.add(pushed[i]);

            } else {
                popedI++;
            }
        }
        for (; popedI < popped.length; popedI++) {
            if (stack.pop() != popped[popedI]) {
                return false;
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pushed = new int[]{1, 2, 3, 4, 5};
//        int[] poped = new int[]{4, 5, 3, 2, 1};
        int[] poped = new int[]{1,2,3,4,5};
        System.out.println(solution.validateStackSequences(pushed, poped));
    }


}
