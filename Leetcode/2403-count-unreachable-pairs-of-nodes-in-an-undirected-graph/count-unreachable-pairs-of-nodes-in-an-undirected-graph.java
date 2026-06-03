class Solution {
    public long countPairs(int n, int[][] edges) {

        List<List<Integer>> adj=new ArrayList<>();
        int parent[]=new int[n];
        int rank[]=new int[n];
        for(int i=0;i<n;i++){ 
            parent[i]=i;
            adj.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
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

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(parent[i],map.getOrDefault(parent[i],0)+1);
        }
        long res=0;
        long rem=n;
        for(int val:map.values()){
            int size=val;
            res+=size*(rem-size);
            rem=rem-size;
        }

        return res;

    }

    public int find(int i,int parent[]){
        if(i==parent[i]) return i;

        return parent[i]=find(parent[i],parent);
    }

    public void union(int a,int b,int parent[],int rank[]){
        
        int parent_a=find(a,parent);
        int parent_b=find(b,parent);

        if(parent_a==parent_b) return;

        if(rank[parent_a]>rank[parent_b]){
            parent[b]=parent_a;
        }
        else if(rank[parent_a]<rank[parent_b]){
            parent[a]=parent_b;
        }
        else{
            parent[b]=parent_a;
            rank[a]++;
        }
    }

}