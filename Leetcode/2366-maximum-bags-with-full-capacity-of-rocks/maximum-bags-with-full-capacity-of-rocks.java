class Solution {
    
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<capacity.length;i++){
            q.add(capacity[i]-rocks[i]);
        }
        int count=0;
        for(int i=0;i<capacity.length;i++){
            int reqrocks=q.poll();
            if(additionalRocks>=reqrocks){
                additionalRocks-=reqrocks;
                count++;
            }
        }
        return count;
    }
}