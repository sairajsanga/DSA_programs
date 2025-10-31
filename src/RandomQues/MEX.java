package RandomQues;

import java.util.*;

class MEX{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int arr[]=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=sc.nextInt();
            }
            System.out.println(findSmallestInteger(arr,k));
        }
    }
    public static int findSmallestInteger(int[] nums, int value) {
        int n=nums.length;
        int result[]=new int[n+value];
        if(value==0) return 0;
        for(int num:nums){
            int rem=(num%value+value)%value;
            result[rem]++;
        }

        for(int i=0;i<=n+value;i++){
            if(result[i%value]>0){
                result[i%value]--;
            }
            else{
                return i;
            }
        }
        return -1;
    }
}
