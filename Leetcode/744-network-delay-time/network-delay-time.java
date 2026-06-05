class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[]:times){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            adj.get(u).add(new int[]{w,v});
        }


        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        dist[k]=0;
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int curr[]=pq.poll();

            int wt=curr[0];
            int u=curr[1];

            if(wt>dist[u]) continue;

            for(int edge[]:adj.get(u)){
                int neighcost=edge[0];
                int neighnode=edge[1];

                if(wt+neighcost<dist[neighnode]){
                    dist[neighnode]=wt+neighcost;
                    pq.offer(new int[]{dist[neighnode],neighnode});
                }

            }
        }

        int max=-1;

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,dist[i]);
        }

        return max;


    }
}