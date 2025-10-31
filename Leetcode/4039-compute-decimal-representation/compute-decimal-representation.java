import java.util.*;
class Solution {
    public int[] decimalRepresentation(int n) {
       int temp=n;
       int count=0;
       List<Integer> list=new ArrayList<>();
       while(temp!=0){
         int rem=temp%10;
         int ans=rem*(int)Math.pow(10,count);
         if(ans!=0){
            list.add(ans);
         }  
         count++;
         temp/=10;
       }
       Collections.reverse(list);
       int res[]=new int[list.size()];
       int idx=0;
       for(int ele:list){
          res[idx++]=ele;
       }
    //    reverse(res);
       return res;
    }
    // public void reverse(int arr[]){
    //     int i=0;
    //     int j=arr.length-1;
    //     while(i<=j){
    //         int temp=arr[i];
    //         arr[i]=arr[j];
    //         arr[j]=temp;
    //         i++;
    //         j--;
    //     }
    // }
}