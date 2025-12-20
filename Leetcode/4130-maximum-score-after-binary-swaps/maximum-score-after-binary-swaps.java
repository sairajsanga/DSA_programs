class Solution {
    public long maximumScore(int[] nums, String s) {
        int n=nums.length;
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->Integer.compare(b,a));
       long sum=0;
        for(int i=0;i<n;i++){
            q.add(nums[i]);  
            if(s.charAt(i)=='1'){
                if(!q.isEmpty()&&q.peek()>=nums[i]){
                    sum+=q.poll();
                }
            }         
        }

        return sum;
    }
}