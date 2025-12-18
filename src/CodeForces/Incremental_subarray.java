package CodeForces;

import java.util.Scanner;

public class Incremental_subarray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int arr[]=new int[m];
            for(int i=0;i<m;i++){
                arr[i]=sc.nextInt();
            }
            boolean flag=false;
            for(int i=1;i<m;i++){
               if(arr[i]!=arr[i-1]+1){
                   flag=true;
                   break;
               }
            }
            if(flag){
                System.out.println(1);
            }
            else{
                int end=arr[arr.length-1];
                System.out.println(n-end+1);
            }
        }
    }
}
