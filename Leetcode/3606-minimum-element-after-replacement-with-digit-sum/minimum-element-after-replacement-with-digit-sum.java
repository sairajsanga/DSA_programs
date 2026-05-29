class Solution {
    public int minElement(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int sum=0;
            while(num!=0){
                int rem=num%10;
                sum+=rem;
                num=num/10;
            }
            min=Math.min(sum,min);
        }
        return min;
    }   
}