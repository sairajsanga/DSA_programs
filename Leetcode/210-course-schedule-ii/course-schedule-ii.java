class Solution {
    List<Integer> res;
    Stack<Integer> stack;
    public int[] findOrder(int numCourses, int[][] nums) {

        boolean visited[]=new boolean[numCourses];
        boolean inRecursion[]=new boolean[numCourses];
        this.stack=new Stack<>();
        this.res=new ArrayList<>();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int num[]:nums){
            adj.get(num[1]).add(num[0]);
        }

        for(int i=0;i<numCourses;i++){
            if(!visited[i]&&DFS(adj,i,visited,inRecursion)){
                return new int[]{};
            }
        }
        
       
        
        while(!stack.isEmpty()){
             res.add(stack.pop());        
        }
        int result[]=new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;  
    }

     public boolean DFS( List<List<Integer>> adj,int u,boolean visited[],boolean inRecursion[]){

        visited[u]=true;
        inRecursion[u]=true;
       
        
        for(int v:adj.get(u)){
            if(!visited[v]&&DFS(adj,v,visited,inRecursion)) return true;
            else if(inRecursion[v]) return true;
        }  
        stack.push(u);
        inRecursion[u]=false;
        return false;
    }
}