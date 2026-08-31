class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        int indegree[]=new int[n];

        List<List<Integer>> adj=new ArrayList<>();

        int size=edges.size();
        for(int i=0;i<size;i++){
            List<Integer> list=edges.get(i);
            int u=list.get(0);
            int v=list.get(1);

            indegree[v]++;
        }

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
           if(indegree[i]==0) res.add(i);
        }

        return res;
    }
}