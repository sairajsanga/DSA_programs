package AdityaDp;

import java.util.Arrays;
import java.util.Scanner;

public class palin_part_mem_ {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String s1=sc.nextLine();
        int n=s1.length();
        int dp[][]=new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(solve(s1,0,n-1,dp));

    }
    public static int solve(String s1,int i,int j,int dp[][]){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(ispalindrome(s1,i,j)){
            return 0;
        }

        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempans=solve(s1,i,k,dp)+solve(s1,k+1,j,dp)+1;
            min=Math.min(min,tempans);
        }
        return dp[i][j]=min;
    }

    public static boolean  ispalindrome(String s1,int i,int j){
        while(i<j){
            if(s1.charAt(i)!=s1.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
