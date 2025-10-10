import java.util.*;

public class Solution {
    // Double hashing parameters
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;
    private static final long BASE1 = 911382323L; // < MOD1
    private static final long BASE2 = 972663749L; // < MOD2

    public String longestDupSubstring(String s) {
        int n = s.length();
        if (n <= 1) return "";

        // Precompute prefix hashes and powers
        long[] pow1 = new long[n + 1], pow2 = new long[n + 1];
        long[] pre1 = new long[n + 1], pre2 = new long[n + 1];
        pow1[0] = pow2[0] = 1L;
        for (int i = 0; i < n; i++) {
            pow1[i + 1] = (pow1[i] * BASE1) % MOD1;
            pow2[i + 1] = (pow2[i] * BASE2) % MOD2;
            pre1[i + 1] = (pre1[i] * BASE1 + (s.charAt(i) - 'a' + 1)) % MOD1;
            pre2[i + 1] = (pre2[i] * BASE2 + (s.charAt(i) - 'a' + 1)) % MOD2;
        }

        // Helpers to get hash of s[l..r] inclusive
        java.util.function.BiFunction<Integer,Integer,long[]> getHash = (l, r) -> {
            long h1 = (pre1[r + 1] - (pre1[l] * pow1[r - l + 1]) % MOD1 + MOD1) % MOD1;
            long h2 = (pre2[r + 1] - (pre2[l] * pow2[r - l + 1]) % MOD2 + MOD2) % MOD2;
            return new long[]{h1, h2};
        };

        // Check if there exists a duplicate of length L; returns start index or -1
        java.util.function.IntUnaryOperator check = (L) -> {
            if (L == 0) return 0;
            Map<Long, List<Integer>> seen = new HashMap<>();
            for (int i = 0; i + L <= n; i++) {
                long[] h = getHash.apply(i, i + L - 1);
                long key = (h[0] << 32) ^ h[1];
                List<Integer> lst = seen.get(key);
                if (lst != null) {
                    for (int j : lst) {
                        // Verify to eliminate any residual collision
                        if (s.regionMatches(j, s, i, L)) return i;
                    }
                    lst.add(i);
                } else {
                    List<Integer> l = new ArrayList<>(1);
                    l.add(i);
                    seen.put(key, l);
                }
            }
            return -1;
        };

        int lo = 1, hi = n - 1, bestStart = -1, bestLen = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int pos = check.applyAsInt(mid);
            if (pos != -1) {
                bestStart = pos;
                bestLen = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return bestStart == -1 ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}