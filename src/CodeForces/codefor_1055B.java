package CodeForces;

import java.util.Scanner;

public class codefor_1055B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int rk=sc.nextInt();
            int ck=sc.nextInt();
            int rd=sc.nextInt();
            int cd=sc.nextInt();

            int diffx=Math.min(0,rk-rd);
            int diffy=Math.min(0,ck-cd);

            int lengthrk=n-rk;
            int lengthck=n-ck;
            int result=Math.max(diffx+lengthrk,diffy+lengthck);
            System.out.println(result);
        }
    }
}
