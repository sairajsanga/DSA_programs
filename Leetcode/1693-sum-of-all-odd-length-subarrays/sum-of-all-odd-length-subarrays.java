class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int prefix[]=new int[arr.length+1];
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+arr[i-1];
        }
        int oddsum=0;
        for(int i=1;i<=n;i++){
           for(int j=i;j<=n;j++){
               if((j-i+1)%2!=0){
                  oddsum+=prefix[j]-prefix[i-1];
               }
           } 
        }
        return oddsum;

    }
}