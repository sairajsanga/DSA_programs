class Solution {
    int min;
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int d=road[2];

            adj.get(u).add(new int[]{v,d});
            adj.get(v).add(new int[]{u,d});
        }
        boolean visited[]=new boolean[n+1];
        this.min=Integer.MAX_VALUE;
        dfs(1,adj,visited);
        return min;
    }
    public void dfs(int u,List<List<int[]>> adj,boolean visited[]){

        visited[u]=true;

        for(int road[]:adj.get(u)){
            int v=road[0];
            int d=road[1];
            
            min=Math.min(min,d);
            if(!visited[v]){
                dfs(v,adj,visited);
            }
        }
    }
}