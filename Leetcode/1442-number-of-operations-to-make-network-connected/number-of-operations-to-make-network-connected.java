class Solution {
    public int makeConnected(int n, int[][] connections) {

        int m=connections.length;

        if(n-1>m) return -1;

        List<List<Integer>> adj=new ArrayList<>();

        int parent[]=new int[n];
        int rank[]=new int[n];


        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
           parent[i]=i;
        }



        for(int edge[]:connections){
           int u=edge[0];
           int v=edge[1];

           adj.get(u).add(v);
        }

        int comp=n;

        for(int u=0;u<n;u++){
            for(int v:adj.get(u)){
                int parentu=find(u,parent);
                int parentv=find(v,parent);

                if(parentu!=parentv){
                    union(u,v,parent,rank);
                    comp--;
                }
            }
        }


       return comp-1;
    }

        public int find(int i,int parent[]){
        
        if(i==parent[i]) return i;
        
        return parent[i]=find(parent[i],parent);
    }
    
    public void union(int x,int y,int parent[],int rank[]){

        int x_parent=find(x,parent);
        int y_parent=find(y,parent);
        
        if(x_parent==y_parent) return;
        
        if(rank[x_parent]>rank[y_parent]){
            parent[y_parent]=x_parent;
        }
        else if(rank[x_parent]<rank[y_parent]){
            parent[x_parent]=y_parent;
        }
        else{
            parent[x_parent]=y_parent;
            rank[y_parent]+=1;
        }
    }
}