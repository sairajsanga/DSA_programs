package CodeForces;

import java.util.Scanner;

public class Ashmal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String arr[]=new String[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.next();
            }


                String s = arr[0];
                for (int i = 1; i < n; i++) {
                   String front=arr[i]+s;
                   String back=s+arr[i];

                   if(front.compareTo(back)<0){
                       s=front;
                   }
                   else{
                       s=back;
                   }
                }
                System.out.println(s);

        }
    }
}
