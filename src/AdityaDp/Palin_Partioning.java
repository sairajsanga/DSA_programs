package AdityaDp;

import java.util.Scanner;

public class Palin_Partioning {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String s1=sc.nextLine();
        int n=s1.length();
        System.out.println(solve(s1,0,n-1));

    }
    public static int solve(String s1,int i,int j){
        if(i>=j){
            return 0;
        }
        if(ispalindrome(s1,i,j)){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int tempans=solve(s1,i,k)+solve(s1,k+1,j)+1;
            min=Math.min(min,tempans);
        }
        return min;
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
