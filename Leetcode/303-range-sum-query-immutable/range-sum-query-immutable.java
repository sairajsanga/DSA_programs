class NumArray {
    

    int prefix[];
    public NumArray(int[] nums) {
   
        int n=nums.length;

        this.prefix=new int[n+1];
        
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        right++;
        if(left==0) return prefix[right];
        return prefix[right]-prefix[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */