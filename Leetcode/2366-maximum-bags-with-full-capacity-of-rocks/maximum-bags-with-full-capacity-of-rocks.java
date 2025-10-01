class Solution {
    class Pair{
        int max;
        int rocks;
        public Pair(int max,int rocks){
            this.max=max;
            this.rocks=rocks;
        }
    }
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        // int totalmaxrocks=0;
        // for(int num:capacity){
        //    totalmaxrocks+=num;
        // }
        // if(additionalRocks>totalmaxrocks){
        //     return capacity.length;
        // }
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<capacity.length;i++){
            list.add(new Pair(rocks[i],capacity[i]-rocks[i]));
        }

        Collections.sort(list,(a,b)->a.rocks-b.rocks);

        int count=0;
        for(Pair p:list){
            int reqrocks=p.rocks;
            if(additionalRocks>=reqrocks){
                additionalRocks-=reqrocks;
                count++;
            }
        }
        return count;
    }
}