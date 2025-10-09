class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        long[] f = new long[n];
        for(int x : mana) {
            long now = f[0];
            // (1 to n) ->
            for(int i = 1; i < n; i++) {
                now = f[i] = Math.max(f[i], now + ((long)skill[i - 1] * x));
            }
            f[n - 1] = now + (long)skill[n - 1] * x;
            // (n-2 to 0) <-
            for(int i = n - 2; i >= 0; i--) {
                f[i] = f[i + 1] - ((long)skill[i + 1] * x);
            }
        }
        return f[n - 1];
    }
}