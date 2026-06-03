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
                bfs(adj,visited,i);
                res+=size*(rem-size);
                rem-=size;
            }
        }
        return res;

    }

    public void bfs(List<List<Integer>> adj,boolean visited[],int u){
        Queue<Integer> q=new LinkedList<>();
        q.add(u);
        visited[u]=true;
        size++;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int v:adj.get(curr)){
               if(!visited[v]){
                  visited[v]=true;
                  q.add(v);
                  size++;
               }
           }
        }
    }

    // public void dfs(List<List<Integer>> adj,boolean visited[],int u){

    //     visited[u]=true;
    //     size++;
    //     for(int v:adj.get(u)){
    //         if(!visited[v]){
    //             dfs(adj,visited,v);
    //         }
    //     }
    // }
}
