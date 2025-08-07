import java.util.Arrays;
import java.util.Scanner;

public class product_arrays {
    public static int [] productofitself(int []nums){
        int n=nums.length;
        int [] leftproduct=new int[n];
        int [] rightproduct=new int[n];
        int [] output=new int[n];

        leftproduct[0]=1;
        //left product
        for(int i=1;i<n;i++){
            leftproduct[i]=leftproduct[i-1]*nums[i-1];
        }
        //right product
        rightproduct[n-1]=1;
        for(int i=n-2;i>=0;i--){
            rightproduct[i]=rightproduct[i+1]*nums[i+1];
        }

        //product of left and right
        for(int i=0;i<n;i++){
            output[i]=leftproduct[i]*rightproduct[i];
        }
        return output;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int num=sc.nextInt();
        int []nums=new int[num];
        System.out.println("Enter the elements in array");
        for(int i=0;i<num;i++){
            nums[i]=sc.nextInt();
        }
       int outputarr[]= productofitself(nums);
        System.out.println("the product array of itself");
        System.out.println(Arrays.toString(outputarr));
    }
}

