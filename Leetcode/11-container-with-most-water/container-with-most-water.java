class Solution {
    public int maxArea(int[] height) {
        

        int start=0;
        int end=height.length-1;

        int area=0;
        int max=0;
        while(start<=end){
            if(height[start]<=height[end]){
                area=(end-start)*height[start];
                start++;
            }
            else if(height[start]>height[end]){
                area=(end-start)*height[end];
                end--;
            }
            max=Math.max(max,area);
        }
        return max;
    }
}