class Solution {
    class Pair{
        int value;
        int idx;
        public Pair(int idx,int value){
     
            this.idx=idx;
            this.value=value;
        }
    }
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {

        int n=aliceValues.length;


        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->b.value-a.value);


        for(int i=0;i<n;i++){
            q.offer(new Pair(i,aliceValues[i]+bobValues[i]));
        }

        int aliceScore=0;
        int bobScore=0;
        int person=1;
        boolean visited[]=new boolean[n];

        while(!q.isEmpty()){
            Pair curr=q.poll();
            int val=curr.value;
            int index=curr.idx;

             if(person==1){
             
                if(visited[index]) continue;

                aliceScore+=aliceValues[index];
                visited[index]=true;
                person=0;

             }
             else{
    
                if(visited[index]) continue;

                bobScore+=bobValues[index];
                visited[index]=true;
                person=1;
             }
        }
        
        System.out.println(aliceScore);
        System.out.println(bobScore);
        if(aliceScore>bobScore) return 1;
        else if(aliceScore<bobScore) return -1;
        else return 0;
    }
}