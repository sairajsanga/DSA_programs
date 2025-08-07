package Kunal_programs;

public class DLL {

    Node head;
    int size;

    public DLL() {
        this.size = 0;
    }

    public void insertbtw(int val,int index){
        Node node=new Node(val);
        if(index>size){
            return;
        }
        if(index==0){
            insertfirst(val);
        } else if (index==size) {
            inserlast(val);
        }

        else {
            Node temp = get(index - 1);
            node.next = temp.next;
            temp.next = node;
            node.prev = temp;
            node.next.prev = node;

            size++;
        }
    }

    public void removelast(){
        Node secoundlast=get(size-2);
        secoundlast.next=null;
        size--;
    }
    public Node get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    public int removefirst(){
        int val=head.val;
        head=head.next;
        if(head==null){
            head=null;
        }
        size--;
        return val;
    }

    public void inserlast(int val){
        Node node=new Node(val);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        node.prev=temp;
        node.next=null;
        size++;
    }

    public void display(){
        Node temp=head;
        while(temp!=null) {
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
        System.out.print("END");
    }

    public void insertfirst(int val){
        Node node=new Node(val);
//        if(head==null){
//            head=node;
//            node.next=null;
//            node.prev=null;
//            return;
//        }
        node.next=head;
        if(head!=null) {
            head.prev = node;
        }
        node.prev=null;
        head=node;
        size++;
    }

    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val,Node next,Node prev) {
            this.val = val;
            this.next=next;
            this.prev=prev;
        }
    }

}
