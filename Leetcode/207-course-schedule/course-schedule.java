class Solution {
    public boolean canFinish(int numCourses, int[][] nums) {
        boolean visited[]=new boolean[numCourses];
        boolean inRecursion[]=new boolean[numCourses];

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int num[]:nums){
            adj.get(num[1]).add(num[0]);
        }

        for(int i=0;i<numCourses;i++){
            if(!visited[i]&&DFS(adj,i,visited,inRecursion)) return false;
        }
        return true;
    }

    public boolean DFS( List<List<Integer>> adj,int u,boolean visited[],boolean inRecursion[]){

        visited[u]=true;
        inRecursion[u]=true;

        for(int v:adj.get(u)){
            if(!visited[v]&&DFS(adj,v,visited,inRecursion)) return true;
            else if(inRecursion[v]) return true;
        }  

        inRecursion[u]=false;
        return false;
    }
}