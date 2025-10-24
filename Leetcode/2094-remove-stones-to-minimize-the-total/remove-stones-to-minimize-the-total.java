class Solution {
    public int minStoneSum(int[] piles, int k) {
       PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->b-a);
       for(int i=0;i<piles.length;i++){
          q.add(piles[i]);
       } 
       int sum=0;
       while(k!=0){
          int val=q.poll();
          val-=val/2;
          q.add(val);
          k--;
       }
       while(!q.isEmpty()){
          sum+=q.poll();
       }
       return sum;
    }
}