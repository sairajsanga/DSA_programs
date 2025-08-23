package Kunal_programs;

import java.util.Scanner;

public class recrback {
    public static int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    public static int helper(int nums[],int start,int xor){
        if(start==nums.length){
            return xor;
        }
        int left=helper(nums,start+1,xor^nums[start]);
        int right=helper(nums,start+1,xor);
        return left+right;
    }


    public static void main(String[] args) {
        int nums[]={1,3};
        System.out.println(subsetXORSum(nums));

    }

    public static class SEG {
        public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int q=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }

            for(int i=1;i<=q;i++) {
                int a=sc.nextInt();
                int b=sc.nextInt();
                SEG tree=new SEG(arr);
                System.out.println(tree.query(a-1,b-1));
            }
        }
        Nodee root;
        public SEG(long arr[]) {
            this.root=construct(arr,0,arr.length-1);
        }
        public Nodee construct(long arr[], int s, int e){
            if(s==e){
                Nodee leaf=new Nodee(s,e);
                leaf.dataa=arr[s];
                return leaf;
            }
            Nodee node=new Nodee(s,e);
            int mid=s+(e-s)/2;
            node.left=this.construct(arr,s,mid);
            node.right=this.construct(arr,mid+1,e);

            node.dataa=node.left.dataa+node.right.dataa;
            return node;
        }
        public long query(int qsi,int qei){
            return query(this.root,qsi,qei);
        }
        private long query(Nodee node, int qsi, int qei){
            if(node.startt>=qsi&&node.endd<=qei){
                return node.dataa;
            }
            else if(node.endd<qsi||node.startt>qei){
                return 0;
            }
            else {
                return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
            }
        }

        public void update(int value,int index){
            this.root.dataa=update(this.root,value,index);
        }
        private long update(Nodee node, int value, int index){
            if(index>=node.startt&&index<=node.endd){
                if(index==node.startt&&index==node.endd){
                    node.dataa =value;
                    return node.dataa;
                }
                else{
                    long upleft=this.update(node.left,value,index);
                    long upright=this.update(node.right,value,index);
                    node.dataa =upleft+upright;
                    return node.dataa;
                }
            }
            return node.dataa;
        }
        public class Nodee {
            long dataa;
            int startt;
            int endd;
            Nodee left;
            Nodee right;
            public Nodee(int start, int endd){
                this.startt =start;
                this.endd = endd;
            }
        }
    }
}
