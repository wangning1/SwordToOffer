/**
 * @Description:
 * @CreateDate: 2020/4/24 18:34
 * @Author: wangning
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pHead = new ListNode(-1);
        ListNode tmp;
        while (head != null) {
            tmp = head.next;
            head.next = pHead.next;
            pHead.next = head;
            head = tmp;
        }
        return pHead.next;
    }

    public void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        solution.printList(head);
        solution.printList(solution.reverseList(head));
    }
}
