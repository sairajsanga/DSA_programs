class Solution {
    int n;

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj=new ArrayList<>();

        this.n=isConnected.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean visited[]=new boolean[n];

        int count=0;
       for(int i=0;i<n;i++){
          if(!visited[i]){
              DFS(adj,i,visited);
              count++;
          }
       }
       return count;
    }
    public void DFS( List<List<Integer>> adj,int u,boolean visited[]){
        
        visited[u]=true;
        
        for(int v:adj.get(u)){
            if(!visited[v]){
                DFS(adj,v,visited);
            }
        }
    }
}