class Solution {
    public int[] findOrder(int numCourses, int[][] nums) {

        int indegree[]=new int[numCourses];



        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int num[]:nums){
            adj.get(num[1]).add(num[0]);
            indegree[num[0]]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.add(i);
        }
        int result[]=new int[numCourses];
        int idx=0;

        while(!q.isEmpty()){
            int node=q.poll();
            result[idx++]=node;

            for(int v:adj.get(node)){
                    indegree[v]--;
                    if(indegree[v]==0){
                        q.add(v);
                    }
            }
        }
        

        return numCourses==idx?result:new int[]{};  
    }

    //  public void BFS( List<List<Integer>> adj,int u,boolean visited[],int indegree[]){

        
        
    // }
}