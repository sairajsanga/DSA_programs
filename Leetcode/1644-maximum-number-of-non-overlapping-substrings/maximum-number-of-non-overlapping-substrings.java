class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // First and last occurrence
        for (int i = 0; i < n; i++) {

            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Generate valid intervals
        for (int c = 0; c < 26; c++) {

            if (first[c] == -1) {
                continue;
            }

            int start = first[c];

            int[] interval = getInterval(
                s,
                start,
                first,
                last
            );

            if (interval != null) {
                intervals.add(interval);
            }
        }

        // Sort by ending index
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> res = new ArrayList<>();

        int previousEnd = -1;

        for (int[] interval : intervals) {

            int start = interval[0];
            int end = interval[1];

            if (start > previousEnd) {

                res.add(s.substring(start, end + 1));

                previousEnd = end;
            }
        }

        return res;
    }

    private int[] getInterval(
        String s,
        int start,
        int[] first,
        int[] last
    ) {

        int end = last[s.charAt(start) - 'a'];

        for (int i = start; i <= end; i++) {

            int c = s.charAt(i) - 'a';

            // Character occurs before our start
            if (first[c] < start) {
                return null;
            }

            // Need to include all occurrences
            end = Math.max(end, last[c]);
        }

        return new int[]{start, end};
    }
}