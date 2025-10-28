class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                nums[i]=nums[i]*-1;
            }
            total+=nums[i];
        }

        Arrays.sort(nums);
        long greaterele=0;
        if(n%2!=0){
             greaterele=(n/2)+1;
        }
        else{
            greaterele=n/2;
        }
        long max=0;
        long temp=greaterele;
        for(int i=n-1;greaterele!=0;i--){
            max+=nums[i]*nums[i];
            greaterele--;
        }
        long diff=0;
        for(int i=0;i<n-temp;i++){
           diff+=nums[i]*nums[i]; 
        }
        long score=max-diff;
        return score;
    }
}