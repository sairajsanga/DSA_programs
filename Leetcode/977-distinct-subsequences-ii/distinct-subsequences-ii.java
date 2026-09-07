class Solution {

    int MOD = 1_000_000_007;
    long[] dp;
    int[] nextSame;

    public int distinctSubseqII(String s) {

        int n = s.length();

        dp = new long[n + 1];
        Arrays.fill(dp, -1);

        nextSame = new int[n];
        int[] last = new int[26];
        Arrays.fill(last, -1);

        // next occurrence of the same character
        for(int i = n - 1; i >= 0; i--) {
            nextSame[i] = last[s.charAt(i) - 'a'];
            last[s.charAt(i) - 'a'] = i;
        }

        return (int)((solve(s, 0) - 1 + MOD) % MOD); // remove empty subsequence
    }

    long solve(String s, int i) {

        if(i == s.length()) return 1; // empty subsequence

        if(dp[i] != -1) return dp[i];

        long ans = (2 * solve(s, i + 1)) % MOD;

        // Remove duplicates caused by the next same character
        if(nextSame[i] != -1) {
            ans = (ans - solve(s, nextSame[i] + 1) + MOD) % MOD;
        }

        return dp[i] = ans;
    }
}