/**
 * @Description:
 * @CreateDate: 2020/4/24 14:09
 * @Author: wangning
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        //先定义个头结点，使通用性
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        //定义后指针
        ListNode lastHead = pHead;
        //先走K步
        while (k-- >= 0) {
            if (lastHead == null) {
                return null;
            }
            lastHead = lastHead.next;
        }
        while (lastHead != null) {
            lastHead = lastHead.next;
            pHead = pHead.next;
        }
        return pHead.next;
    }

    public void printList(ListNode head) {
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
        ListNode kthNode = solution.getKthFromEnd(head, 5);
        solution.printList(kthNode);

    }
}
