package AdityaDp;

import java.util.Scanner;

public class LCS_recr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String 1:");
        String s1=sc.nextLine();
        System.out.println("Enter the String 2:");
        String s2=sc.nextLine();
        System.out.println(LCSrec(s1,s2,s1.length(),s2.length()));
    }
    public static int LCSrec(String s1,String s2,int n,int m){
        if(n==0||m==0){
            return 0;
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
           return 1+LCSrec(s1,s2,n-1,m-1);
        }
        return Math.max(LCSrec(s1,s2,n-1,m),LCSrec(s1,s2,n,m-1));
    }

}
