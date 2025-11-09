class Solution {
    public int longestSubarray(int[] nums) {
       int n=nums.length;
       if(n == 1) return 1;
       int prefix[]=new int[n];
       int suffix[]=new int[n];
       int l=1;
       int r=n-2;
       prefix[0]=1;
       suffix[n-1]=1;
       HashSet<Integer> set=new HashSet<>();
       while(l<n&&r>=0){
          if(nums[l]<nums[l-1]){
             prefix[l]=1;
             set.add(l);
          }else{
            prefix[l]=prefix[l-1]+1;
          }
          
          if(nums[r+1]<nums[r]){
            suffix[r]=1;
            set.add(r);
          }
          else{
            suffix[r]=suffix[r+1]+1;
          }
          l++;
          r--;
       }
       int maxLength=0;
       for(int pre:prefix){
          maxLength=Math.max(maxLength,pre);
       }
       for(int idx:set){
         int leftlength=(idx>0)?prefix[idx-1]:0;
         int rightlength=(idx+1<n)?suffix[idx+1]:0;
         
         if(idx>0&&idx+1<n&&nums[idx-1]<=nums[idx+1]){
            maxLength=Math.max(maxLength,leftlength+rightlength+1);
         }
         else{
            maxLength=Math.max(maxLength,Math.max(leftlength,rightlength)+1);
         }
       }
       return maxLength<=n?maxLength:n;
    }
}