class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long l = Long.MAX_VALUE, sum = 0;
        for(int i = 0; i < batteries.length; i++) {
            l = Math.min(l, (long) batteries[i]);
            sum += (long) batteries[i];
        }
        long r = (sum / n);
        long ans = l;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            if(isPossible(batteries, mid, n)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] batteries, long mid, int n) {
        long target_sum = (mid * n);
        long sum = 0;
        for(int i = 0; i < batteries.length; i++) {
            sum += Math.min(mid, (long) batteries[i]);
            if(sum >= target_sum) return true;
        }
        return false;
    }
}