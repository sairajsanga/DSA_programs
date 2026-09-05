class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        

        for(int flight[]:flights){
            int u=flight[0];
            int v=flight[1];
            int c=flight[2];

            adj.get(u).add(new int[]{v,c});
        }

        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<int[]> q=new LinkedList<>();
        
        dist[src]=0;
        q.add(new int[]{src,0,0});
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int u=curr[0];
            int c=curr[1];
            int stops=curr[2];
            
            if(stops>k) continue;

            for(int next[]:adj.get(u)){
               int nv=next[0];
               int nc=next[1];
  
               if(c+nc<dist[nv]){
                  dist[nv]=c+nc;
                  q.add(new int[]{nv,dist[nv],stops+1});
               }
            }
        }

        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}