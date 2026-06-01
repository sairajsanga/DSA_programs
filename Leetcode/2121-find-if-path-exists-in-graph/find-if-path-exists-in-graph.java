class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n==1) return true;

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int edge[]:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean visited[]=new boolean[n];

       return dfs(adj,source,destination,visited);

    }

    public boolean dfs(List<List<Integer>> adj,int source,int destination,boolean visited[]){

        visited[source]=true;

        if(source==destination) return true;

        for(int v:adj.get(source)){
            if(!visited[v]){
                if(dfs(adj,v,destination,visited)) return true;
            }
        }

        return false;
    }
}