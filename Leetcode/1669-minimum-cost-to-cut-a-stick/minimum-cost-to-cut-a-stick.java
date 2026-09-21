class Solution {
    int arr[];
    Integer dp[][];
    public int minCost(int n, int[] cuts) {

        int m= cuts.length;
        this.arr=new int[m+2];
        this.dp=new Integer[m+2][m+2];
    

        arr[0]=0;
        arr[m+1]=n;
        for(int i=0;i<m;i++){
            arr[i+1]=cuts[i];
        }

        Arrays.sort(arr);
        return solve(arr,0,m+1);
    }

    public int solve(int nums[],int i,int j){

        if(j-i<=1) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        int min=Integer.MAX_VALUE/2;
        for(int k=i+1;k<j;k++){
            int tempans=solve(nums,i,k)+solve(nums,k,j)+(nums[j]-nums[i]);
            min=Math.min(min,tempans);
        }

        return dp[i][j]=min;
    }
}