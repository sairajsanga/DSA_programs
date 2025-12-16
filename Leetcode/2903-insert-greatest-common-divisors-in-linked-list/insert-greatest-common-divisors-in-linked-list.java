/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null)
            return head;

        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode New = getcommondivis(curr, next);
            curr.next = New;
            New.next = next;

            curr = next;
            next = next.next;
        }
        return head;
    }

    public ListNode getcommondivis(ListNode node1, ListNode node2) {
        ListNode gcd = new ListNode();
        int num1 =node1.val;
        int num2 =node2.val;
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        gcd.val = num1;
        return gcd;
    }
}