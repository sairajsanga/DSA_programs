class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;

        long total = 0;
        int max = 0;
        for (int ele : candies) {
            total += ele;
            max = Math.max(max, ele);
        }

        if (total < k)
            return 0;

        long start = 1;
        long end = max;
        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (solve(candies, mid, k)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int)end;
    }

    public boolean solve(int[] nums, long mid, long k) {

        if (mid == 0)
            return true;

        long children = 0;

        for (int candies : nums) {
            children += candies / mid;

            if (children >= k) {
                return true;
            }
        }

        return false;
    }
}