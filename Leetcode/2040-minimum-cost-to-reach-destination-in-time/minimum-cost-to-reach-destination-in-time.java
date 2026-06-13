class Solution {
    int n;
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        this.n=passingFees.length;
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
           adj.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int t=edge[2];

            adj.get(u).add(new int[]{v,t});
            adj.get(v).add(new int[]{u,t});
        }
        
        // int cost[]=new int[n];
        // Arrays.fill(cost,Integer.MAX_VALUE);

        // for(int i=0;i<n;i++){
        //     graph.get(i).add(new Node())
        // }

       return helper(adj,passingFees,maxTime);

    }

    public int helper(List<List<int[]>> adj,int passingTime[],int maxTime){

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int minTime[]=new int[n];
        Arrays.fill(minTime,Integer.MAX_VALUE);
        q.add(new int[]{0,0,passingTime[0]});
        minTime[0]=0;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int u=curr[0];
            int t=curr[1];
            int c=curr[2];

            if(u==n-1) return c;

            for(int neigh[]:adj.get(u)){
                int neighnode=neigh[0];
                int neightime=neigh[1];
                
                int newTime=t+neightime;
                int newcost=c+passingTime[neighnode];

                if(newTime>maxTime) continue;

                if(newTime<minTime[neighnode]){
                    minTime[neighnode]=newTime;
                    q.add(new int[]{neighnode,newTime,newcost});
                }   
            }
        }
       
        return -1;
    }


}