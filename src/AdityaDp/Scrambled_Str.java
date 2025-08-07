package AdityaDp;

import java.util.Scanner;

public class Scrambled_Str {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string 1:");
        String s1=sc.nextLine();
        System.out.println("Enter the string 2:");
        String s2=sc.nextLine();
        if(s1.length()!=s2.length()){
            System.out.println("false");
        }
        else if(s1.length()==0&&s2.length()==0) {
            System.out.println("true");
        }
        System.out.println(solve(s1,s2));
    }
    public static boolean solve(String s1,String s2){
        if(s1.compareTo(s2)==0){
            return true;
        }
        if(s1.length()<=1){
            return false;
        }
        int n=s1.length();
        boolean flag =false;
        for(int i=1;i<=n-1;i++){
            if(solve(s1.substring(0, i), s2.substring(0, i)) && solve(s1.substring(i, n), s2.substring(i, n))||solve(s1.substring(0, i), s2.substring(n - i, n)) && solve(s1.substring(i, n), s2.substring(0, n - i))){
                flag=true;
                break;
            }
        }
        return flag;
    }
}
