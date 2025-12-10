class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalfuel=0;
        int totalcost=0;

        for(int i=0;i<n;i++){
            totalfuel+=gas[i];
            totalcost+=cost[i];
        }

        if(totalfuel<totalcost) return -1;


        int currfuel=0;
        int start=0;

        for(int i=0;i<n;i++){
            currfuel+=gas[i]-cost[i];
            if(currfuel<0){
                currfuel=0;
                start=i+1;
            }
        }
        
        return start;

    }
}