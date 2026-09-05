class Solution {
    Integer dp[][];
    public int minSwap(int[] nums1, int[] nums2) {
        int n=nums1.length;
        this.dp=new Integer[n][2];

        
        
        return solve(nums1,nums2,n,0,false);
    }

    public int solve(int nums1[],int nums2[],int n,int idx,boolean swapped){
        if(idx==n) return 0;

        if(dp[idx][swapped?0:1]!=null) return dp[idx][swapped?0:1];

        int prev1=idx>0?nums1[idx-1]:-1;
        int prev2=idx>0?nums2[idx-1]:-1;
        int minswaps=Integer.MAX_VALUE;

        if(swapped){
            int temp=prev1;
            prev1=prev2;
            prev2=temp;
        }

        if(nums1[idx]>prev1&&nums2[idx]>prev2){
            minswaps=solve(nums1,nums2,n,idx+1,false);
        }
        if(nums1[idx]>prev2&&nums2[idx]>prev1){
            minswaps=Math.min(minswaps,1+solve(nums1,nums2,n,idx+1,true));
        }

        return dp[idx][swapped?0:1]=minswaps;
    }
}