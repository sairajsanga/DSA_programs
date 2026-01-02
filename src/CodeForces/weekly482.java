package CodeForces;

public class weekly482 {
    public static void main(String[] args) {
        int nums[]={-7,-5,3};
        int numss[]={1,1};
        System.out.println(maximumScore(nums));
        System.out.println(maximumScore(numss));

    }

        public static long maximumScore(int[] nums) {
            int n=nums.length;
            long prefixsum[]=new long[n+1];
            int suffixMin[]=new int[n];
            for(int i=0;i<n;i++){
                prefixsum[i+1]=prefixsum[i]+nums[i];
            }
            int min=nums[n-1];
            suffixMin[n-1]=min;
            for(int i=n-2;i>=0;i--){
                min=Math.min(min,nums[i]);
                suffixMin[i]=min;
            }

            long max=Long.MIN_VALUE;
            for(int i=1;i<n;i++){
                long score=prefixsum[i]-suffixMin[i];
                max=Math.max(max,score);
            }
            return max;
        }

}
