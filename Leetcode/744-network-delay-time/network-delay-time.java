class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {


        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int edge[]:times){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            adj.get(u).add(new int[]{v,w});
        }
        
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[1]-b[1]);
        dist[k]=0;
        q.add(new int[]{k,0});

        while(!q.isEmpty()){
            int curr[]=q.poll();
            int u=curr[0];
            int cost=curr[1];

            if(cost>dist[u]) continue;

            for(int next[]:adj.get(u)){
                int v=next[0];
                int newCost=cost+next[1];

                if(newCost<dist[v]){
                    dist[v]=newCost;
                    q.add(new int[]{v,newCost});
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