package harry_programs;

import java.util.Scanner;

public class practice_set_methods {
    // Question 1
   /* public static void multiplication(int n){

        for(int i=1;i<=10;i++){
            System.out.format("%d * %d = %d\n",n,i,n*i);
            }
        }*/

    // question 2
   /* public static void pattern1(int n){
        for(int r=1;r<=n;r++){
            for(int c=1;c<=r;c++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // Question 3
    public static void pattern2(int n){
        for(int r=1;r<=n;r++){
            for(int c=r;c<=n;c++){
                System.out.print("*");
            }
            System.out.println();
        }
    }*/

    //  Question 4 sum of n natural numbers
   /* public static int natural(int num){
        if(num<=0){
            return 0;
        }
        else{
            return num+natural(num-1);
        }
    }*/

    // Question 5 using variable arguments find the average of the set of numbers
    /*public static int avg(int ...arr){
      int result=0;
      for(int i=0;i<arr.length;i++){
          result+=arr[i];
      }
      return result;
    }
*/
    public  static void pattern2_rec(int n){

        if(n>0){
            for(int i=0;i<n;i++){
                System.out.print("*");
            }
            System.out.println();
            pattern2_rec(n-1);
        }
    }

    public  static void pattern1_rec(int n){

        if(n>0){
            pattern1_rec(n-1);
            for(int i=0;i<n;i++){
                System.out.print("*");
            }
            System.out.println();

        }
    }
    public static int sumofN(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }


    public static void main(String[] args) {
        // Question 1 multiplication table
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the value of n:");
        int num=sc.nextInt();

        //multiplication(num);

        // printing the pattern
      /*  System.out.println("enter the value of x:");
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();*/
   //       pattern1(x);
   //       pattern2(x);

      //  System.out.println(natural(x));
/*
     // average of array elements

        int [] a={1,2,3,4,5};
        System.out.println("The average of array elements is:");
        int average=avg(a)/a.length;
        System.out.println(average);*/


       pattern1_rec(num);
        pattern2_rec(num);
        System.out.println(sumofN(num));
    }
}
