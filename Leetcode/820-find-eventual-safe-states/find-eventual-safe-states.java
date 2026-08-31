class Solution {
    List<Integer> result;
    int outdegree[];
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> adj=new ArrayList<>();
        int n=graph.length;

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        this.outdegree=new int[n];
        
        for(int i=0;i<n;i++){
            int edge[]=graph[i];
            for(int ele:edge){
                adj.get(i).add(ele);
                outdegree[i]++;
            }   
        }
        this.result=new ArrayList<>();
        boolean visited[]=new boolean[n];
        boolean inRecursion[]=new boolean[n];
        
        for(int i=0;i<n;i++){
            dfs(adj,i,visited,inRecursion);
        }

        for(int i=0;i<n;i++){
            if(!inRecursion[i]){
                result.add(i);
            }
        }

        return result;
    }

    public boolean dfs( List<List<Integer>> adj,int u,boolean visited[],boolean inRecursion[]){

        visited[u]=true;
        inRecursion[u]=true;

        for(int v:adj.get(u)){
            if(!visited[v]&&dfs(adj,v,visited,inRecursion)) return true;
            else if(inRecursion[v]) return true;
        }  

        inRecursion[u]=false;
        return false;
    }


}