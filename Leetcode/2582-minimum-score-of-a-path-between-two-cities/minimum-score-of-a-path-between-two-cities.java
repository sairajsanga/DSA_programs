class Solution {

    class DSU{
        int parent[];
        int weight[];

        public DSU(int n){
            this.parent=new int[n];
            this.weight=new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
                weight[i]=Integer.MAX_VALUE;
            }
        }

        public int find(int a){
            if(parent[a]==a) return a;

            return parent[a]=find(parent[a]);
        }

        public void union(int a,int b,int c){
            int parent_a=find(a);
            int parent_b=find(b);

            if(parent_a==parent_b){
                weight[parent_a]=Math.min(c,weight[parent_a]);
                return;
            }

            parent[parent_b]=parent_a;
            weight[parent_a]=Math.min(c,Math.min(weight[parent_a],weight[parent_b]));
        }
    }
    public int minScore(int n, int[][] roads) {
        DSU dsu=new DSU(n+1);

        for(int road[]:roads){
           dsu.union(road[0],road[1],road[2]);
        }

        return dsu.weight[dsu.find(1)];
    }
}