package Kunal_programs;

import java.util.Scanner;

public class SEGT {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int arr[]=new int[n];
        SEGT tree=new SEGT(arr);
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
       for(int i=0;i<q;i++){
           System.out.println(tree.query(sc.nextInt(),sc.nextInt()));
       }
    }
    Node root;
    public SEGT(int arr[]) {
        this.root=construct(arr,0,arr.length-1);
    }
    public Node construct(int arr[],int s,int e){
        if(s==e){
            Node leaf=new Node(s,e);
            leaf.data=arr[s];
            return leaf;
        }
        Node node=new Node(s,e);
        int mid=s+(e-s)/2;
        node.left=this.construct(arr,s,mid);
        node.right=this.construct(arr,mid+1,e);

        node.data=node.left.data+node.right.data;
        return node;
    }
    public int query(int qsi,int qei){
        return query(this.root,qsi,qei);
    }
    private int query(Node node,int qsi,int qei){
        if(node.start>=qsi&&node.end<=qei){
            return node.data;
        }
        else if(node.end<qsi||node.start>qei){
            return 0;
        }
        else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    public void update(int value,int index){
       this.root.data=update(this.root,value,index);
    }
    private int update(Node node,int value,int index){
        if(index>=node.start&&index<=node.end){
            if(index==node.start&&index==node.end){
                node.data=value;
                return node.data;
            }
            else{
                int upleft=this.update(node.left,value,index);
                int upright=this.update(node.right,value,index);
                node.data=upleft+upright;
                return node.data;
            }
        }
        return node.data;
    }
    public class Node{
        int data;
        int start;
        int end;
        Node left;
        Node right;
        public Node( int start, int end){
            this.start=start;
            this.end=end;
        }
    }
}
