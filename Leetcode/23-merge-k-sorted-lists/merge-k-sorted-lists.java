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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> q=new PriorityQueue<>((a,b)->a.val-b.val);

        for(int i=0;i<lists.length;i++){
            ListNode head=lists[i];
            while(head!=null){
                ListNode newNode=new ListNode(head.val);
                q.add(newNode);
                head=head.next;
            }
        }
        
        ListNode prev=null;
        ListNode result=null;
        while(!q.isEmpty()){
            ListNode curr=q.poll();
            if(prev==null){
                prev=curr;
                result=curr;
            }else{
                prev.next=curr;
                prev=prev.next;
            }
           
        } 

        return result;
    }
}