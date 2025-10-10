class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                return -1;
            }
        }
        int rounds=0;
        for(int i=0;i<tasks.length;i++){
            if(map.getOrDefault(tasks[i],0)==1){
               map.put(tasks[i],map.getOrDefault(tasks[i],0)-1);
               rounds++;
               if(map.getOrDefault(tasks[i],0)==0){
                map.remove(tasks[i]);
               }
            }
            if(map.getOrDefault(tasks[i],0)==2){
               map.put(tasks[i],map.getOrDefault(tasks[i],0)-2);
               rounds++;
               if(map.getOrDefault(tasks[i],0)==0){
                map.remove(tasks[i]);
               }
            }
            if(map.getOrDefault(tasks[i],0)>=3){
               map.put(tasks[i],map.getOrDefault(tasks[i],0)-3);
               rounds++;
                if(map.getOrDefault(tasks[i],0)==0){
                map.remove(tasks[i]);
               }
            }
        }
        return rounds;
    }
}