class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int i,j;
        for(i=0,j=0;i<n&&j<m;j++){
            if(nums1[i]>nums2[j]) i++;
        }

        return Math.max(0,j-i-1);
    }
}