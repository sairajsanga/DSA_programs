class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n=stones.length;

        for(int i=0;i<n;i++){
            stones[i]=stones[i]%3;
        }


        int count2=0;
        int count1=0;
        int count0=0;

        for(int i=0;i<n;i++){
            if(stones[i]==2) count2++;
            else if(stones[i]==1) count1++;
            else count0++;
        }
        

        if(count0%2==0){
            return count1>0&&count2>0;
        }

        return Math.abs(count1-count2)>2;
    }
}