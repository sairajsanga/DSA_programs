public class maxSubarrSum {
    public static void main(String[] args) {
        int arr[]={2,5,1,8,2,9,1};
        int windSize=3;
        System.out.println(sums(arr,arr.length,windSize));
    }
//    public static int solves(int arr[],int n,int k){
//        int sum=sumof(arr,0,k);
//        int maxsum=sum;
//        for(int i=1;i<n-k+1;i++){
//          sum=sum-arr[i-1]+arr[i+k-1];
//          maxsum=Math.max(maxsum,sum);
//        }
//        return maxsum;
//    }
//    public static int sumof(int arr[],int i,int k){
//        int sum=0;
//        while(i!=k){
//            sum+=arr[i];
//            i++;
//        }
//        return sum;
//    }
    public static int sums(int arr[],int n,int k){
        int i=0;
        int j=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        while(j<n){
            sum+=arr[j];
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k) {
                max=Math.max(max,sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return max;
    }
}
