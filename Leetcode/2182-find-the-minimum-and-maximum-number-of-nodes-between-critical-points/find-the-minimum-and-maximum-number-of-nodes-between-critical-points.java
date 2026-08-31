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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        // int size=0;
        // ListNode temp=head;
    
        // while(temp!=null){
        //     temp=temp.next;
        //     size++;
        // }

        // if(size<=2) return new int[]{-1,-1};

        ListNode firstidx=head;
        ListNode prev=null;
        ListNode next=firstidx.next;


        int idx=0;
        
        List<Integer> list=new ArrayList<>();
        while(firstidx!=null&&firstidx.next!=null){

            if(prev!=null&&firstidx.val<prev.val&&firstidx.val<next.val){
                list.add(idx);
            }else if(prev!=null&&firstidx.val>prev.val&&firstidx.val>next.val){
                list.add(idx);   
            }
      
            prev=firstidx;
            firstidx=firstidx.next;
            next=firstidx.next;
            idx++;
        }

        Collections.sort(list);
     
        System.out.println(list);

        if(list.size()<=1) return new int[]{-1,-1};

        int maxDist=list.get(list.size()-1)-list.get(0);

        int minDist=Integer.MAX_VALUE;

        for(int i=1;i<list.size();i++){
            minDist=Math.min(minDist,list.get(i)-list.get(i-1));
        }

        return new int[]{minDist,maxDist};
    }
}