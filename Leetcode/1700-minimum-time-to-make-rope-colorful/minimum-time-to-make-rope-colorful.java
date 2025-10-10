class Solution {
    public int minCost(String colors, int[] neededTime) {
        int prev=0;
        int time=0;
        for(int i=0;i<neededTime.length;i++){
            if(prev==0||colors.charAt(i)==colors.charAt(i-1)){
               time+=Math.min(prev,neededTime[i]);
               prev=Math.max(neededTime[i],prev);
            }
            else{
                prev=neededTime[i];
            }
        }
        return time;
    }
}
