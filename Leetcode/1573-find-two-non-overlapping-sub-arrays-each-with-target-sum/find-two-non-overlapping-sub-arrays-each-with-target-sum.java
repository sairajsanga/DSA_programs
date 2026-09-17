class Solution {
    private int prefix[];
    private Integer dp[];
    private int INF=Integer.MAX_VALUE/2;
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        this.prefix=new int[n+1];
        this.dp=new Integer[n+1];


        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+arr[i];
        }

        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(0,0);
        int ans=INF;
        int best=INF;

        for(int i=1;i<=n;i++){
            int sum=prefix[i];

            if(map.containsKey(sum-target)){
                int j=map.get(sum-target);
                int len=i-j;

                if(j>0 && dp[j-1]<INF){
                    ans=Math.min(ans,len+dp[j-1]);
                }
                best=Math.min(best,len);
            }

            dp[i-1]=best;
            map.put(sum,i);
        }

        return ans>=INF?-1:ans;
    }

    // public int solve(int arr[],int target,int idx,int limit){

    //     if(limit==0) return 0;

    //     if(idx>=arr.length) return Integer.MAX_VALUE/2;

    //     if(dp[idx][limit]!=null) return dp[idx][limit];

    
    //     int sum=Integer.MAX_VALUE/2;

    //     for(int k=idx;k<arr.length;k++){
    //         int currsum=prefix[k+1]-prefix[idx];
    //         if(currsum==target){
    //             int len=k-idx+1;
               
    //             int next=solve(arr,target,k+1,limit-1);
    //             if(next<Integer.MAX_VALUE/2){
    //               sum=Math.min(sum,len+next);
    //             }      
    //         }

    //         if(currsum > target) break;
            
    //     }

    //     int skip=solve(arr,target,idx+1,limit);

    //     return dp[idx][limit]=Math.min(sum,skip);
    // }
}