package Kunal_programs;

import java.util.Scanner;

public class Binarytree {

    public Binarytree() {

    }

    public class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

   Node root;
    public void populate(Scanner sc){
        System.out.print("Enter the root node ");
        int value=sc.nextInt();
        root=new Node(value);
        populate(sc,root);
    }
    public void populate(Scanner sc,Node node){
        System.out.println("Do you want to enter the left of"+node.value);
        boolean left=sc.nextBoolean();
        if(left){
            System.out.println("enter the value of"+node.value);
            int value=sc.nextInt();
            node.left=new Node(value);
            populate(sc,node.left);
        }

        System.out.println("Do you want to enter the right of"+node.value);
        boolean right=sc.nextBoolean();

        if(right){
            System.out.println("enter the value of"+node.value);
            int value=sc.nextInt();
            node.right=new Node(value);
            populate(sc,node.right);
        }
    }

    public void display(){
        display(root,"");
    }
    public void display(Node node,String indent){
        if(node==null) return;
        System.out.println(indent+node.value);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Binarytree tree =new Binarytree();
        tree.populate(sc);
        tree.display();
    }

}
