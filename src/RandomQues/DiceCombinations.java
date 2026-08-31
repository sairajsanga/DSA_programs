package RandomQues;

import java.util.Scanner;

public class DiceCombinations {
    public static final long MOD = 1000000007;
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();

        long dp[]=new long[n+1];
        dp[0]=1;

       for(int i=1;i<=n;i++){
           for(int j=1;j<=6;j++){
               if(j<=i){
                   dp[i]=(dp[i]+dp[i-j])%MOD;
               }
           }
       }

        System.out.println(dp[n]);





    }
}
