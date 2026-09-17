class Solution {
    boolean isPalindrome[][];
    int INF = Integer.MAX_VALUE / 2;
    Integer dp[];
    public int minCut(String s) {
        int n = s.length();

        this.isPalindrome = new boolean[n + 1][n + 1];
        this.dp=new Integer[n+1];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2 || isPalindrome[i + 1][j - 1]) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }

        return solve(s, 0);
    }

    public int solve(String s, int idx) {

        if (idx >= s.length())
            return 0;

        if (isPalindrome[idx][s.length() - 1]) {
            return 0;
        }

        if(dp[idx]!=null) return dp[idx];

        int ans = INF;

       for (int k = idx; k < s.length(); k++) {

            if (isPalindrome[idx][k]) {

                // If k is last character, no cut needed
                if (k == s.length() - 1) {
                    ans = 0;
                    break;
                }

                int next = solve(s, k + 1);

                ans = Math.min(ans, 1 + next);
            }
        }

        return dp[idx]=ans;
    }
}