package RandomQues;

import java.util.Arrays;
import java.util.Scanner;

public class rightproduct_ofarray {
    public static int []rightproduct(int nums[]){
        int n=nums.length;
        int rightproduct[]=new int[n];
        int output[]=new int[n];

        rightproduct[n-1]=1;
        for(int i=n-2;i>=0;i--){
            rightproduct[i]=rightproduct[i+1]*nums[i+1];
        }

        for(int i=0;i<n;i++){
            output[i]=rightproduct[i];
        }
        return output;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int num=sc.nextInt();
        int nums[]=new int[num];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<num;i++){
            nums[i]=sc.nextInt();
        }
        int outputarr[]=rightproduct(nums);
        System.out.println(Arrays.toString(outputarr));
    }
}
