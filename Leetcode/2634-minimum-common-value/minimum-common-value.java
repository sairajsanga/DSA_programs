class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        Set<Integer> set=new HashSet<>();

        for(int ele:nums1){
            set.add(ele);
        }

        for(int i=0;i<m;i++){
           if(set.contains(nums2[i])) return nums2[i];
        }

        return -1;
    }
}