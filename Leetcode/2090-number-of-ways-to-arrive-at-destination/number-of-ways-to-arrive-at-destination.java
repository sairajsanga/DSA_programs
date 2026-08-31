class Solution {
    int MOD=1000000007;
    boolean visited[];
    int count;
     public int bfs(List<List<int[]>> adj,int src,int n){
        
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long dist[]=new long[n];
        int countpaths[]=new int[n];
        Arrays.fill(countpaths,Integer.MAX_VALUE);
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[src]=0;
        countpaths[src]=1;
        q.add(new long[]{0,src});
        

        while(!q.isEmpty()){
            long curr[]=q.poll();
            int node=(int)curr[1];
            long cost=curr[0];

            if(cost>dist[node]) continue;

            for(int neigh[]:adj.get(node)){
                int neighcost=neigh[0];
                int neighnode=neigh[1];

                if(cost+neighcost<dist[neighnode]){
                    dist[neighnode]=cost+neighcost;
                    countpaths[neighnode]=countpaths[node];
                    q.add(new long[]{dist[neighnode],neighnode});
                }
                else if(cost+neighcost==dist[neighnode]){
                    countpaths[neighnode]=(countpaths[neighnode]+countpaths[node])%MOD;
                }
            }
        }

        return countpaths[n-1];
    }
    public int countPaths(int n, int[][] roads) {

        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int t=road[2];
            
            adj.get(u).add(new int[]{t,v});
            adj.get(v).add(new int[]{t,u});
        }
        
        this.visited=new boolean [n];
        this.count=0;
        int cost=bfs(adj,0,n);

        return cost;
    }

    

    
   
}