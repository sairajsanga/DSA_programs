class Solution {
    int max=Integer.MIN_VALUE;
    public int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int area=0;
        while(start<end){
            if(height[start]>=height[end]){
                area=(end-start)*height[end];
                end=end-1;
            }
            else if(height[start]<height[end]){
                area=(end-start)*height[start];
                start=start+1;
            }
            max=Math.max(max,area);
        }
        return max;
    }
}