package Kunal_programs;

public class AVL {
    public AVL() {

    }

    public class Node {
        int value;
        Node left;
        Node right;
        int height;

        public Node(int x) {
            this.value = x;
        }

        public int getValue() {
            return value;
        }


    }

    Node root;

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }




    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    public Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }
        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }
    public Node rotate(Node node){
        //left heavy
        if(height(node.left)-height(node.right)>1){
            //left-left case
            if(height(node.left.left)-height(node.left.right)>0) {
                return rightrotate(node);
            }
            //left-right case
            if(height(node.left.left)-height(node.left.right)<0){
                node.left=leftrotate(node.left);
                return rightrotate(node);
            }
        }
        //right heavy
        if(height(node.left)-height(node.right)<-1){
            //right-right case
            if(height(node.right.left)-height(node.right.right)<0){
                return leftrotate(node);
            }
            //right-left case
            if(height(node.right.left)-height(node.right.right)>0){
                node.right=rightrotate(node.right);
                return leftrotate(node);
            }
        }
        return node;
    }
    public Node rightrotate(Node p){
         Node c=p.left;
         Node t=c.right;

         c.right=p;
         p.left=t;


         p.height=Math.max(height(p.left),height(p.right))+1;
         c.height=Math.max(height(c.left),height(c.right))+1;
         return c;
    }
    public Node leftrotate(Node p){
        Node c=p.right;
        Node t=c.left;

        c.left=p;
        p.right=t;


        p.height=Math.max(height(p.left),height(p.right))+1;
        c.height=Math.max(height(c.left),height(c.right))+1;

        return c;
    }

    public boolean balanced() {
        return balanced(root);
    }

    public boolean balanced(Node node) {
        if (node == null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }


    public static void main(String[] args) {
        AVL tree =new AVL();
       for(int i=0;i<1000;i++){
           tree.insert(i);
       }
        System.out.println(tree.height(tree.root));

    }
}
