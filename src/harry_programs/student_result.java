package harry_programs;

import java.util.Scanner;

public class student_result {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the maths marks:");
        int m=sc.nextInt();
        System.out.println("Enter the physics marks:");
        int p=sc.nextInt();
        System.out.println("Enter the chemistry marks:");
        int c=sc.nextInt();
        System.out.println("Enter the computer marks:");
        int cu=sc.nextInt();
        System.out.println("Enter the social marks:");
        int s=sc.nextInt();

        int percentage=((m+p+c+cu+s)/500)*100;
        System.out.println("student result=:"+percentage);


    }
}
