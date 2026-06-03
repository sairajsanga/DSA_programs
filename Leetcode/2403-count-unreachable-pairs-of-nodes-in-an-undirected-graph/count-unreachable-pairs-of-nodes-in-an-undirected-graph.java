class Solution {
    long size;

    public long countPairs(int n, int[][] edges) {

        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){ 
            adj.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean visited[]=new boolean[n];
        long res=0;
        long rem=n;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                size=0;
                dfs(adj,visited,i);
                res+=size*(rem-size);
                rem-=size;
            }
        }
        return res;

    }

    public void dfs(List<List<Integer>> adj,boolean visited[],int u){

        visited[u]=true;
        size++;
        for(int v:adj.get(u)){
            if(!visited[v]){
                dfs(adj,visited,v);
            }
        }
    }
}
