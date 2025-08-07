package AdityaDp;

import java.util.Scanner;

public class Eval_Exp_true {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String s=sc.nextLine();
        System.out.println(solve(s,0,s.length()-1,true));
    }
    public static int solve(String s,int i,int j,boolean istrue){
        if(i>j) return 0;
        if(i==j){
            if(istrue&& s.charAt(i)=='T'||(!istrue&&s.charAt(i)=='F')){
               return 1;
            }
            else{
                return 0;
            }
        }
        int ans=0;
        for(int k=i+1;k<=j-1;k=k+2){
            int lt=solve(s,i,k-1,true);
            int lf=solve(s,i,k-1,false);
            int rt=solve(s,k+1,j,true);
            int rf=solve(s,k+1,j,false);
            if(s.charAt(k)=='&'){
                if(istrue){
                    ans+=lt*rt;
                }
                else{
                    ans+=(lt*rf)+(lf*rt)+(lf*rf);
                }
            }
            else if(s.charAt(k)=='|'){
                if(istrue){
                     ans+=(lt*rf)+(lf*rt)+(lt*rt);
                }
                else{
                     ans+=lf*rf;
                }
            }
            else if(s.charAt(k)=='^'){
                if(istrue){
                    ans+=(lt*rf)+(lf*rt);
                }
                else{
                    ans+=(lt*rt)+(lf*rf);
                }
            }
        }
        return ans;
    }
}
