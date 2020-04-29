/**
 * @Description:
 * @CreateDate: 2020/4/24 18:51
 * @Author: wangning
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode pHead;
        if (l1.val < l2.val) {
            pHead = l1;
            pHead.next = mergeTwoLists(l1.next, l2);
        } else {
            pHead = l2;
            pHead.next = mergeTwoLists(l1, l2.next);
        }
        return pHead;
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
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);

        Solution solution = new Solution();
        solution.printList(solution.mergeTwoLists(head, head2));
    }
}
