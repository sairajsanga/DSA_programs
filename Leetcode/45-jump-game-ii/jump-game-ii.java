class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int currend=0;
        int currfar=0;
        int jump=0;
        for(int i=0;i<n-1;i++){
           currfar=Math.max(currfar,i+nums[i]);
           if(i==currend){
             jump++;
             currend=currfar;
           }
        }
        return jump;
    }
}