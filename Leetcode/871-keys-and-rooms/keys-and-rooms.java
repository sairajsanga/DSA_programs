class Solution {
    boolean visited[];
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        this.visited=new boolean[n];

        dfs(rooms,0);
        for(int i=0;i<n;i++){
            if(!visited[i]) return false;
        }

        return true;
    }

    public void dfs(List<List<Integer>> rooms,int u){

        visited[u]=true;
        
             for(int v:rooms.get(u)){
                if(!visited[v]){
                    dfs(rooms,v);
                }
            }
    }


}