package RandomQues;

public class SumofIndices {
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5};
        int arr2[]={1,2,3,4,5};

        int nums[]=new int[arr1.length];
        int i=0;
        int j=0;
        int idx=0;
        while(i!=arr1.length&&j!=arr2.length){
            int sum=arr1[i]+arr2[j];
            nums[idx++]=sum;
            i++;
            j++;
        }
        for(int num:nums){
            System.out.println(num);
        }
    }
}
