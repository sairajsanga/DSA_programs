class Solution {
    class Pair {
        int val, dist;
        private Pair(int val, int dist) {
            this.val = val; this.dist = dist;
        }
    }
    public long minMoves(int[] balance) {
        int idx = -1, n = balance.length;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            if(balance[i] < 0) {
                idx = i;
            }
            sum += balance[i];
        }
        if(idx == -1) return 0L;
        if(sum < 0) return -1;

        List<Pair> list=new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(balance[i] < 0) continue;
            int distance = Math.min(Math.abs(i - idx), n - Math.abs(i - idx));
            list.add(new Pair(balance[i], distance));
        }
        Collections.sort(list, (a,b) -> {
            if(a.dist == b.dist) return Integer.compare(b.val, a.val);
            return Integer.compare(a.dist, b.dist);
        });

        long moves = 0;
        for(int i = 0; i < n - 1; i++) {
            int val = list.get(i).val;
            int dist = list.get(i).dist;
            if(Math.abs(balance[idx]) < val && val > 0) {
                moves += (long) Math.abs(balance[idx]) * dist;
                return moves;
            } else {
                balance[idx] += val;
                moves += ((long) val * dist);
            }
        }
        return moves;
    }
}