/**
 * @Description:
 * @CreateDate: 2020/4/24 12:26
 * @Author: wangning
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode p = pHead;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return pHead.next;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        solution.printList(head);
        head = solution.deleteNode(head, 5);
        solution.printList(head);

        head = solution.deleteNode(head, 9);
        solution.printList(head);

    }
}
