class Solution {
    class Pair{
        int value;
        int freq;
        Pair(int value,int freq){
            this.value=value;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->map.getOrDefault(b,0)-map.getOrDefault(a,0));
        int res[]=new int[k];
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
             q.add(entry.getKey());
        }
        for(int i=0;i<k;i++){
            res[i]=q.poll();
        }
        return res;

    }
}