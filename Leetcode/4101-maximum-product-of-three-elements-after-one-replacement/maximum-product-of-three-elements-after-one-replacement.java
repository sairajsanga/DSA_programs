class Solution {
    public long maxProduct(int[] nums) {
        int n=nums.length;
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                temp[i]=nums[i]*-1;
            }
            else{
                temp[i]=nums[i];
            }
        }
        Arrays.sort(temp);
        int first=temp[n-1];
        int secound=temp[n-2];

        Arrays.sort(nums);
        int neg=0;
        if(first!=nums[n-1]||secound!=nums[n-2]){
            neg++;
        }
        
        return (long)first*secound*(100000);      
    }
}