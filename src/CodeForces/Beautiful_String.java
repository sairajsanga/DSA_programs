package CodeForces;

import java.util.Scanner;

public class Beautiful_String {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            int count=0;

            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    count++;
                }
            }

            System.out.println(count);
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    System.out.print(i+1+" ");
                }
            }
            System.out.println();
        }
    }
}
