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
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->b.freq-a.freq);
        HashMap<Integer,Integer> map=new HashMap<>();
        int res[]=new int[k];
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
             q.add(new Pair(entry.getKey(),entry.getValue()));
        }
        for(int i=0;i<k;i++){
            Pair ans=q.poll();
            res[i]=ans.value;
        }
        return res;

    }
}