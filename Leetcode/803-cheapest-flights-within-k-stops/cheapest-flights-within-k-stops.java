class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int flight[]:flights){
            int u=flight[0];
            int v=flight[1];
            int c=flight[2];

            adj.get(u).add(new int[]{c,v});
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

       Queue<int[]> pq=new LinkedList<>();

        pq.offer(new int[]{0,src,0});
        dist[src]=0;
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int c=curr[0];
            int u=curr[1];
            int stops=curr[2];

            if(stops>k) continue;

            for(int flight[]:adj.get(u)){
                int neighnode=flight[1];
                int neighcost=flight[0];

                if(c+neighcost<dist[neighnode]){
                    dist[neighnode]=c+neighcost;
                    pq.offer(new int[]{dist[neighnode],neighnode,stops+1});
                }
            }
        }  

        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}