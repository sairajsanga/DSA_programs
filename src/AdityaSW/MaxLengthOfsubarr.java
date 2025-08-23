package AdityaSW;

public class MaxLengthOfsubarr {
    public static void main(String[] args) {
        int arr[]={4,1,1,1,2,3,5};
        int n=arr.length;
        int sum=10;
        System.out.println(findLargestSum(arr,n,sum));
    }
    public static int findLargestSum(int nums[],int n,int k){
        int i=0;
        int j=0;
        int maxSize=0;
        int sum=0;
        while(j<n){
            sum+=nums[j];
            if(sum<k){
                j++;
            }
            else if(sum==k){
                   maxSize=Math.max(maxSize,j-i+1);
                   j++;
            }
            else{
                while(sum>k){
                    sum-=nums[i];
                    i++;
                    if(sum==k){
                        maxSize=Math.max(maxSize,j-i+1);
                    }
                }
                j++;
            }
        }
        return maxSize;

    }
}
