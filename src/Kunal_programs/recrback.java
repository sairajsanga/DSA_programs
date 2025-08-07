package Kunal_programs;

public class recrback {
    public static int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    public static int helper(int nums[],int start,int xor){
        if(start==nums.length){
            return xor;
        }
        int left=helper(nums,start+1,xor^nums[start]);
        int right=helper(nums,start+1,xor);
        return left+right;
    }


    public static void main(String[] args) {
        int nums[]={1,3};
        System.out.println(subsetXORSum(nums));

    }
}
