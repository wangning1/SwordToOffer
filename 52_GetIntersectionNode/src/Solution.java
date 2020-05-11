/**
 * @authour winner
 * @Date 2020/5/11 22:27
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;
        int lenA = listLenth(pA);
        int lenB = listLenth(pB);
        int num = 0;
        if (lenA > lenB) {
            num = lenA - lenB;
            while (num-- > 0) {
                headA = headA.next;
            }
        } else if (lenA < lenB) {
            num = lenB - lenA;
            while (num-- > 0) {
                headB = headB.next;
            }
        }
        if (headA == null || headB == null) {
            return null;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
            if (headA == null || headB == null) {
                return null;
            }
        }
        return headA;
    }

    private int listLenth(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
