package RandomQues;

import java.util.Scanner;

public class FenwickTree {

    static int[] bit;
    static int n=5;

   public static void update(int i,int val){
       while(i<=n) {
           bit[i] = bit[i] + val;
           i += i & (-i);
       }
   }

   public static int sum(int i){
      int s=0;
      while(i>0){
          s+=bit[i];
          i=i-(i&(-i));
      }
      return s;
   }
   public static void build(int arr[]){

      for(int i=1;i<=n;i++){
          update(i,arr[i]);
      }
   }
   public static int rangesum(int l,int r){
       return sum(r)-sum(l-1);
   }

   public static int lowerbound(int val){
       int curr=0;
       int presum=0;
       for(int i=(int)(Math.log(n)/Math.log(2));i>=0;i--){
           if(bit[curr+(1<<i)]+presum<val){
               curr=curr+(1<<i);
               presum+=bit[curr];
           }
       }
       return curr+1;
   }

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int arr[]=new int[n+1];
       bit=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }

        build(arr);
        System.out.println(rangesum(2,4));
        System.out.println(lowerbound(6));

    }


}
