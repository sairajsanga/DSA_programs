package AdityaDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class primeSumtoN {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;

        // Eliminate even numbers and multiples of 3 early
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Check from 5 to √n skipping even numbers
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of N:");
        int n=sc.nextInt();
        System.out.println("Enter the value of M");
        int m=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        int count=0;
        for(int i=2;i<=50;i++){
            if(isPrime(i)){
                list.add(i);
                count++;
            }
            if(count>=m){
                break;
            }
        }
       if(helpeer(n,m,list)!=Integer.MAX_VALUE-1){
           System.out.println(helpeer(n,m,list));
       }
       else{
           System.out.println("-1");
       }
    }
    public static int helpeer(int n,int m,List<Integer> list){
        int dp[][]=new int[m+1][n+1];
        for(int []row:dp){
            Arrays.fill(row,Integer.MAX_VALUE-1);
        }
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(list.get(i-1)<=j&&dp[i][j-list.get(i-1)]!=Integer.MAX_VALUE-1){
                    dp[i][j]=Math.min(1+dp[i][j-list.get(i-1)],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

}
