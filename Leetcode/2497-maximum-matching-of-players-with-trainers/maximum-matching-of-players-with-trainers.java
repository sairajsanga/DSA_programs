class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
       
       int m=players.length;
       int n=trainers.length;

       int res=0;

       Arrays.sort(players);
       Arrays.sort(trainers);
       int i=0,j=0;
       while(i<m&&j<n){
          int num=players[i];
          if(num<=trainers[j]){
             res++;
             i++;
             j++;
          }
          else{
          j++;
          }
       }
       return res;
    }
}