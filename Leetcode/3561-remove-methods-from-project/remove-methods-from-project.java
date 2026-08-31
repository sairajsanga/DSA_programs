class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : invocations) {
            adj.get(e[0]).add(e[1]);
        }

        boolean[] suspicious = new boolean[n];
        dfs(k, adj, suspicious);

        for (int[] e : invocations) {
            int u = e[0], v = e[1];
            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int u, List<List<Integer>> adj, boolean[] suspicious) {
        suspicious[u] = true;
        for (int v : adj.get(u)) {
            if (!suspicious[v]) {
                dfs(v, adj, suspicious);
            }
        }
    }
}