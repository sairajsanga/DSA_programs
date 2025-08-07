package Kunal_programs;

public class PopNextRight {
    public PopNextRight() {
    }

    public class Node{
        int val;
        Node left;
        Node right;
        Node next;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node left,Node right,Node next){
            this.val=val;
            this.left=left;
            this.right=right;
            this.next=next;
        }
    }
    public Node connect(Node root) {
        if(root==null) return null;

        Node leftmost=root;
        while(leftmost.left!=null){
            Node curr=leftmost;
            while(curr!=null){
                curr.left.next=curr.right;
                if(curr.next!=null){
                    curr.right.next=curr.next.left;
                }
                curr=curr.next;
            }
            leftmost=leftmost.left;
        }
        return root;
    }

    public static void main(String[] args) {
        PopNextRight pop=new PopNextRight();

    }
}
