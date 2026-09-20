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
    public ListNode reverseBetween(ListNode head, int left, int right) {
          
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode beforeLeft=dummy;
        ListNode curr=head;
        for(int i=1;i<left;i++){
            beforeLeft=beforeLeft.next;
        }
        ListNode rightNode=beforeLeft;
        for(int i=left;i<=right;i++){
             rightNode=rightNode.next;
        }

        ListNode rightPart=rightNode.next;
        rightNode.next=null;

        ListNode leftNode=beforeLeft.next;
        ListNode reverse=reverseList(leftNode);

        beforeLeft.next=reverse;
        while(reverse.next!=null){
            reverse=reverse.next;
        }

        reverse.next=rightPart;
        return dummy.next;
    }

     public ListNode reverseList(ListNode head) {
       ListNode prev=null;
       ListNode curr=head;
       ListNode temp=null;
       
       while(curr!=null){
         temp=curr.next;
         curr.next=prev;
         prev=curr;
         curr=temp;

       } 
       return prev;
    }
}