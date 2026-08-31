class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int edge[] = graph[i];
            for (int v : edge) {
                adj.get(i).add(v);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        dfs(0, n - 1, adj, result, new ArrayList<>());
        return result;
    }

    public void dfs(int src, int dst, List<List<Integer>> adj, List<List<Integer>> res, List<Integer> temp) {

        temp.add(src);

        if (src == dst) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int v : adj.get(src)) {
                dfs(v, dst, adj, res, temp);
            }
        }

        temp.remove(temp.size() - 1);
    }
}