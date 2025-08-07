package harry_programs;

import java.util.Scanner;

public class armstrong {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int num=sc.nextInt();
       if(isarmstrong(num)==num){
           System.out.println("It is a armstrong number");
       }
       else{
           System.out.println("It is not a armstrong number");
       }
    }
    public static int isarmstrong(int num) {
        int digits=0;
        int temp = num;
        int sum=0;
        while (temp > 0) {
            temp /= 10;
            digits++;
        }
        System.out.println("No of didits:"+digits);

        temp=num;

        while (temp > 0) {
            int lastdigit = temp % 10;
            sum += Math.pow(lastdigit, digits);
            temp /= 10;
        }
        System.out.println("sum is:"+sum);
        return sum;
    }
}

