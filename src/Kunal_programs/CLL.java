package Kunal_programs;

public class CLL {
    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

    }

      private Node head;
      private Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insertfirst(int val){
          Node node=new Node(val);
          if(head==null){
              head=node;
              tail=node;
              return;
          }

          tail.next=node;
          node.next=head;
          tail=node;
    }
    public void display(){
        Node temp=head;
        if(head!=null){
            do{
                System.out.print(temp.val+"-->");
                temp=temp.next;
            }while(temp!=head);
        }

    }


    // cycle detection using fast and slow pointer method
    public  boolean cycledetection(){
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
    public void insert(int val,int index){

        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(val);
        node.next=temp.next;
        temp.next=node;
    }

    public static void main(String[] args) {
        CLL list=new CLL();
        list.insertfirst(2);
        list.insertfirst(3);
        list.insertfirst(4);
        list.insertfirst(5);
        list.insertfirst(6);
        list.insert(1,0);
        list.insert(0,5);
        list.display();
        System.out.println();
        System.out.println(list.cycledetection());
    }
}
