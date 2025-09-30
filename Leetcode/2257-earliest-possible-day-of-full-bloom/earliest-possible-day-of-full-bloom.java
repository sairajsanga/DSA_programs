class Solution {
    class Pair{
        int first;
        int secound;
        Pair(int first,int secound){
           this.first=first;
           this.secound=secound;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Pair> list=new ArrayList<>();
        int n=plantTime.length;
        for(int i=0;i<n;i++){
            list.add(new Pair(plantTime[i],growTime[i]));
        }
        Collections.sort(list,(a,b)->b.secound-a.secound);

        int prevplantdays=0;
        int maxBloomdays=0;
        for(int i=0;i<n;i++){
            int currPlantdays=list.get(i).first;
            int currGrowdays=list.get(i).secound;
            
            prevplantdays+=currPlantdays;
            int currBloomdays=prevplantdays+currGrowdays;
            maxBloomdays=Math.max(maxBloomdays,currBloomdays);
        }
        return maxBloomdays;
    }
}