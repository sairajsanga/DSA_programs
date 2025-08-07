package AdityaDp;

import java.util.Arrays;
import java.util.Scanner;

public class MCM_rec {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int n=sc.nextInt();
        System.out.println("Enter the valus in array");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int dp[][]=new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(solve(arr,1,arr.length-1,dp));
    }
    public static int solve(int arr[],int i,int j,int dp[][]){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempans=solve(arr,i,k,dp)+solve(arr,k+1,j,dp)+(arr[i-1]*arr[k]*arr[j]);
            min=Math.min(min,tempans);
        }
        return dp[i][j]=min;
    }

}
