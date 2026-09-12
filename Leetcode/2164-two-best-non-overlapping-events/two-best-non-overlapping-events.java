class Solution {

    public int maxTwoEvents(int[][] events) {

        int n = events.length;

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // suffixMax[i] = maximum value among events i...n-1
        int[] suffixMax = new int[n];

        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(
                events[i][2],
                suffixMax[i + 1]
            );
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int value = events[i][2];

            // Find first event whose start > current end
            int j = binarySearch(events, events[i][1]);

            if (j < n) {
                value += suffixMax[j];
            }

            ans = Math.max(ans, value);
        }

        return ans;
    }

    private int binarySearch(int[][] events, int end) {

        int low = 0;
        int high = events.length - 1;
        int ans = events.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (events[mid][0] > end) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}