class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;

        int merged[]=new int[m+n];

        int i=0;
        int j=0;
        int idx=0;
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                merged[idx++]=nums1[i];
                i++;
            }
            else{
                merged[idx++]=nums2[j];
                j++;
            }
        }

        while(i<m){
           merged[idx++]=nums1[i];
           i++;
        }
        while(j<n){
            merged[idx++]=nums2[j];
            j++;
        }

        int total=merged.length;
        if(total%2==0){
            return (double)(merged[total/2-1]+merged[total/2])/2.0;
        }
        
        else{
            return (double)merged[total/2];
        }
    }
}