package AdityaDp;

import java.util.Arrays;
import java.util.Scanner;

public class eggdrop {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of floors");
        int n=sc.nextInt();
        System.out.println("Enter no of eggs");
        int e=sc.nextInt();
        int dp[][]=new int[n+1][e+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(solve(n,e,dp));
    }
    public static int solve(int n,int e,int dp[][]){
        if(n==0||n==1){
            return n;
        }
        if(e==1){
            return n;
        }
        if(dp[n][e]!=-1){
            return dp[n][e];
        }
        int min=Integer.MAX_VALUE;
//        int low=1;
//        int high=n;

        for(int k=1;k<=n;k++){
            int temp=1+Math.max(solve(k-1,e-1,dp),solve(n-k,e,dp));
            min=Math.min(min,temp);
        }
        //binary search (reducing search space)
//        while(low<=high){
//            int k=low+(high-low)/2;
//            int breaks=solve(k-1,e-1,dp);
//            int nobreak=solve(n-k,e,dp);
//            int tempans=1+Math.max(breaks,nobreak);
//            min=Math.min(min,tempans);
//            if(breaks>nobreak){
//                high=k-1;
//            }
//            else{
//                low=k+1;
//            }
//        }
        return  dp[n][e]=min;
    }
}
