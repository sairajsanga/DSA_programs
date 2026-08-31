class Solution {
    public int maximumPopulation(int[][] logs) {
        int m=logs.length;

       int res[]=new int[2051];
        for(int log[]:logs){
            int birth=log[0];
            int death=log[1];
             
            res[birth]++;
            
            res[death]--;

        }
        int max=Integer.MIN_VALUE;

        for(int year=1;year<=2050;year++){
            res[year]+=res[year-1];
            max=Math.max(max,res[year]);
        }

       for(int i=0;i<res.length;i++){
          if(res[i]==max){
            return i;
          }
       }
       return -1;

    }
}