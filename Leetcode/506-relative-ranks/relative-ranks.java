class Solution {
    public String[] findRelativeRanks(int[] score) {
       PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->b[0]-a[0]);
       for(int i=0;i<score.length;i++){
           q.add(new int[]{score[i],i});
       } 
       String res[]=new String[score.length];
       int count=1;
       for(int i=0;i<score.length;i++){
          if(count==1){
             int index=q.poll()[1];
             res[index]="Gold Medal";
             count++;
          }
          else if(count==2){
            int index=q.poll()[1];
            res[index]="Silver Medal";
            count++;
          }
          else if(count==3){
            int index=q.poll()[1];
            res[index]="Bronze Medal";
            count++;
          }
          else{
             int index=q.poll()[1];
             res[index]=Integer.toString(i+1);
             count++;
          }
       }
       return res;
    }
}