class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String dup = searchForDuplicateOfLength(s, mid);
            if (dup != null) {
                result = dup;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private String searchForDuplicateOfLength(String s, int L) {
        if (L == 0) return "";

        final long mod1 = 1_000_000_007L;
        final long mod2 = 1_000_000_009L;
        final long base = 256L;
        int n = s.length();

        long pow1 = 1, pow2 = 1;
        for (int i = 0; i < L; i++) {
            pow1 = (pow1 * base) % mod1;
            pow2 = (pow2 * base) % mod2;
        }

        long h1 = 0, h2 = 0;
        for (int i = 0; i < L; i++) {
            int val = s.charAt(i);
            h1 = (h1 * base + val) % mod1;
            h2 = (h2 * base + val) % mod2;
        }

        Map<Long, ArrayList<Integer>> map = new HashMap<>();
        long key = combineHashes(h1, h2);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(0);

        for (int i = L; i < n; i++) {
            int leftVal = s.charAt(i - L);
            int newVal = s.charAt(i);

            h1 = (h1 * base - (leftVal * pow1) % mod1 + mod1) % mod1;
            h1 = (h1 + newVal) % mod1;

            h2 = (h2 * base - (leftVal * pow2) % mod2 + mod2) % mod2;
            h2 = (h2 + newVal) % mod2;

            key = combineHashes(h1, h2);
            if (map.containsKey(key)) {
                for (int start : map.get(key)) {
                    int newStart = i - L + 1;
                    if (s.regionMatches(start, s, newStart, L)) {
                        return s.substring(newStart, newStart + L);
                    }
                }
                map.get(key).add(i - L + 1);
            } else {
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(i - L + 1);
            }
        }
        return null;
    }

    private long combineHashes(long h1, long h2) {
        return (h1 << 32) ^ h2;
    }
}