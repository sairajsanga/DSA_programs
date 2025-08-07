package harry_programs;

import java.util.Scanner;

public class binaryconversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /*String binary = Integer.toBinaryString(n);
        System.out.println(binary);*/
        String binary=findbinary(n);
        System.out.println(binary);
    }
    public static  String findbinary(int num){
        StringBuilder sd=new StringBuilder();
            while(num>0){
               sd.insert(0,num%2);
               num=num/2;
            }
         return sd.toString();
    }
}



