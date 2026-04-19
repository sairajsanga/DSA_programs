class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
       int max=0;
       for(int i=0;i<n;i++){
          int ele=nums1[i];
          int idx=binarySearch(ele,0,m-1,nums2);
          if(idx<0) continue;
          max=Math.max(max,idx-i);
        }
        return max;
       
    }

    public int binarySearch(int ele,int low,int high,int nums[]){
       

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]>=ele){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low-1;
    }
}