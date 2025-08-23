package RandomQues;

import java.util.Scanner;

public class pattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         pattern1(n);
    }
    public static void pattern1(int n){
           for(int i=1;i<=n-1;i++){
               for(int j=1;j<=i;j++) {
                   System.out.print(j);
               }
               System.out.println();
           }
           for(int i=n;i>=1;i--){
               for(int j=1;j<=i;j++) {
                   System.out.print(j);
               }
               System.out.println();
           }

    }

   public static void patterns(int n){
       int count=1;
       for(int i=1;i<=n;i++){
           for(int j=1;j<=i;j++){

               System.out.print(count+" ");
               count++;
           }
           System.out.println();
       }
   }

}
