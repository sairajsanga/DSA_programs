package Kunal_programs;

import java.util.HashSet;

public class LL {
      public Node head;
      public Node tail;
      public int size;

    public LL() {
        this.size =0;
    }

    // cycle detection  fast and slow pointer method
    public boolean cycledetection(){
        Node fast=head;
        Node slow=head;

        while(fast!=null&& fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                return true;
            }
        }
        return false;
    }

    public int removefirst(){
       int val=head.val;
       head=head.next;
       if(head==null){
           tail=null;
       }
       size--;
       return  val;
    }
    public int removelast(){
        if(size<=1){
            return removefirst();
        }
        int val=tail.val;
        Node secoundlast=get(size-1);
        tail=secoundlast;
        secoundlast.next=null;
        size--;
        return  val;
    }
    public Node get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    public void insert(int val,int index){
        if(index==0){
            Insertfirst(val);
            return;
        }
        if(index==size){
            InserLast(val);
            return;
        }

        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }

    public  void InserLast(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        tail=node;
        node.next=null;
    }

    public void Display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
        System.out.print("END");
    }

    public Node delete_comm(int nums[],Node head){
        HashSet<Integer> set=new HashSet<>();
        for(int ele:nums){
            set.add(ele);
        }

        Node dummy=new Node(0,head);
        Node prev=dummy;
        Node current=head;


        while(current!=null){
          if(set.contains(current.val)){
                prev.next=current.next;
            }
            else {
                prev = prev.next;
            }
            current=current.next;
        }
        return dummy.next;
    }

    public void Insertfirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }


    private class Node{
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val=val;
            this.next = next;
        }
    }


}
