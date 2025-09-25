class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=q.poll();
        }
        return res;
    }
}