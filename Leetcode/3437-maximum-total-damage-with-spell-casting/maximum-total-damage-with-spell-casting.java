class Solution {
    HashMap<Integer,Integer> map;
    HashMap<Integer, Long> memo;
    public long maximumTotalDamage(int[] power) {
        int n=power.length;
        this.map=new HashMap<>();
        this.memo=new HashMap<>();
        for(int i:power){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> list=new ArrayList<>(map.keySet());

        Collections.sort(list);
        return getMax(list,0,list.size());
    }
    public long getMax(List<Integer> list,int index,int n){
        if(index>=n){
           return 0;
        }
        if(memo.containsKey(list.get(index))){
            return memo.get(list.get(index));
        }

        int nextIndex=index+1;
        while(nextIndex<n&&Math.abs(list.get(nextIndex) - list.get(index)) <= 2){
            nextIndex++;
        }
        long damage=(long)list.get(index)*(long)map.get(list.get(index));
        long takedamage=damage+getMax(list,nextIndex,n);
        long notake=getMax(list,index+1,n);
        memo.put(list.get(index),Math.max(takedamage,notake));
        return Math.max(takedamage,notake);
    }
}