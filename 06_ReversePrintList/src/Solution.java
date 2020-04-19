import java.util.*;

/**
 * @authour winner
 * @Date 2020/4/19 9:15
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            result[i] = stack.pop();
            i++;
        }
        return result;
    }

    /**
     * 递归求解
     *
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        List<Integer> resultList = new ArrayList<Integer>();
        recursion(head, resultList);
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    void recursion(ListNode node, List<Integer> resultList) {
        if (node != null) {
            recursion(node.next, resultList);
            resultList.add(node.val);
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.reversePrint(head)));
        System.out.println(Arrays.toString(solution.reversePrint2(head)));
    }
}
