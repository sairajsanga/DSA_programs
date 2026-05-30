class Solution {
    int colors[];
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            int edge[]=graph[i];
            for(int ele:edge){
                adj.get(i).add(ele);
            }
        }

        this.colors=new int[n];
        Arrays.fill(colors,-1);

        for(int i=0;i<n;i++){
            if(colors[i]==-1){
                if(!BFS(adj,i,1)) return false;
            }
        }

        return true;

    }

    public boolean BFS( List<List<Integer>> adj,int curr,int currcolor){
        Queue<Integer> q=new LinkedList<>();
        q.add(curr);
        colors[curr]=currcolor;

        while(!q.isEmpty()){
            int node=q.poll();
            int nodecolor=colors[node];

            for(int v:adj.get(node)){
                if(colors[v]==nodecolor) return false;

                if(colors[v]==-1){
                    colors[v]=1-nodecolor;
                    q.add(v);
                }
            }

        }
        return true;
    }
}