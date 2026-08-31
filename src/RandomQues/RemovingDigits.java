package RandomQues;

import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigits {
    static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);


       System.out.println(solve(n));

    }

    public static int solve(int n){

        dp[0]=0;

        for(int i=1;i<=n;i++){
            String s=Integer.toString(i);
            for(char c:s.toCharArray()){
                int digit=c-'0';
                if(digit!=0){
                    dp[i]=Math.min(dp[i],dp[i-digit]+1);
                }
            }
        }

        return dp[n];


    }
}