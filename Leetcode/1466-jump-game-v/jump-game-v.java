class Solution {
    /*
      x range--> 0<x<=d

      jump condition from i to j

      arr[i]>arr[j] && arr[i]>arr[k] 
      where k is indices btw i and j 
    */
   int dp[];
    public int maxJumps(int[] arr, int d) {
       int n=arr.length;
       int maxvisits=0;
       this.dp=new int[n+1];
       Arrays.fill(dp,-1);
       for(int i=0;i<n;i++){
          maxvisits=Math.max(maxvisits,helper(arr,d,i));
       }


        return maxvisits;
    }

    public int helper(int arr[],int d,int start){
        if(dp[start]!=-1) return dp[start];
        int max=0;
        
        for(int x=1;x<=d;x++){
            if(start+x>=arr.length) break;
            if(arr[start+x]>=arr[start]) break;   

            int forward=helper(arr,d,start+x);
            max=Math.max(max,forward);
        }
        for(int x=1;x<=d;x++){
           if(start-x<0) break;
           if(arr[start-x]>=arr[start]) break;
               
            int backward=helper(arr,d,start-x);
            max=Math.max(max,backward);  
        }
        
        return dp[start]=max+1;
    }
}