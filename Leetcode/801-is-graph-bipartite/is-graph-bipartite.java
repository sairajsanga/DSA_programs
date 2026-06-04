class Solution {

    class DSU{
        int [] parent,rank;

        public DSU(int n){
            this.parent=new int[n];
            this.rank=new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
            }

        }
        

        public int find(int u){
            if(u==parent[u]) return u;

            return parent[u]=find(parent[u]);
        }

        public void union(int u,int v){
            int u_p=find(u);
            int v_p=find(v);
            

            if(u_p==v_p) return;

            if(rank[u_p]>rank[v_p]){
                parent[v_p]=u_p;
            }
            else if(rank[u_p]<rank[v_p]){
                parent[u_p]=v_p;
            }
            else{
                parent[v_p]=u_p;;
                rank[u_p]++;
            }
        }



        
    }
 
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }

        DSU dsu=new DSU(n);
       
        for(int u=0;u<n;u++){

           if(graph[u].length==0) continue;
           
           int firstneigbour=graph[u][0];

           for(int v:graph[u]){

              

               int u_p=dsu.find(u);
               int v_p=dsu.find(v);

               if(u_p==v_p) return false;
              
                dsu.union(firstneigbour,v);
                
           }
        }

        return true;
    }
}