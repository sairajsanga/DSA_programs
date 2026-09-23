class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] edges, int[][] queries) {

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
        }

       
       List<Boolean> res=new ArrayList<>();

        for(int q[]:queries){
            int u=q[0];
            int v=q[1];
            boolean visited[]=new boolean[numCourses];
            res.add(dfs(adj,u,visited,v));
        }
        return res;
    }

    public boolean dfs(List<List<Integer>> adj,int src,boolean visited[],int dest){
        visited[src]=true;
        
        if(src==dest) return true;

        for(int v:adj.get(src)){
            if(!visited[v]){
                if(dfs(adj,v,visited,dest)) return true;
            }          
        }

        return false;
    }
}