package Kunal_programs;

public class BST {
    public BST() {

    }
    public class Node{
       int value;
       Node left;
       Node right;
       int height;
       public Node(int x){
           this.value=x;
       }
        public int getValue() {
            return value;
        }
    }

    Node root;
   public int height(Node node){
       if(node==null){
           return -1;
       }
       return node.height;
   }
   public boolean isEmpty(){
       return root==null;
   }

   public void insert(int value){
      root=insert(value,root);
   }
   public Node insert(int value,Node node){
       if(node==null){
          node=new Node(value);
          return node;
       }
       if(value<node.value){
          node.left=insert(value,node.left);
       }
       if(value>node.value){
           node.right=insert(value,node.right);
       }
       node.height=Math.max(height(node.left),height(node.right))+1;
       return node;
   }
   public boolean balanced(){
      return balanced(root);
   }
   public boolean balanced(Node node){
       if(node==null) return true;
       return Math.abs(height(node.left)-height(node.right))<=1&&balanced(node.left)&&balanced(node.right);
   }
    public void display(){
        display(root,"root Node:");
    }
    public void display(Node node,String details){
        if(node==null){
            return;
        }
        System.out.println(details+node.value);
        display(node.left,"Left child of "+node.value+":");
        display(node.right,"right child of "+node.value+":");
    }
   public void populate(int nums[]){
       for(int i=0;i<nums.length;i++){
           this.insert(nums[i]);
       }
   }
   public void populatesort(int nums[]){
       populatesort(nums,0,nums.length-1);
   }
   public void populatesort(int nums[],int start,int end){
      if(start>=end) {
         return;
      }
      int mid=(start+end)/2;
      this.insert(nums[mid]);
      populatesort(nums,start,mid);
      populatesort(nums,mid+1,end);

   }

    public static void main(String[] args) {
        BST tree=new BST();
        int nums[]={1,2,3,4,5,6,7,8,9,10};
        tree.populatesort(nums);
        tree.display();
    }


}
