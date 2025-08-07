package harry_programs;

import java.util.Scanner;


public class recursive_fn {
   /*
    public static int factorial(int n){
        if(n==0||n==1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
*/
    public static int fibonacci(int n){
        if(n<0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else{
            return fibonacci(n-1)+fibonacci(n-2);
        }

    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("enter the value of n");
        int n=sc.nextInt();
        // System.out.format("the factorial of %d is %d",n,factorial(n));
        System.out.println(fibonacci(n));

    }
}
