class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int MOD = 1_000_000_007;
        long[] nums = new long[n];
        Arrays.fill(nums, 1);

        for (int sec = 0; sec < k; sec++) {
            for (int i = 1; i < n; i++) {
                nums[i] = (nums[i] + nums[i - 1]) % MOD;
            }
        }
        return (int) nums[n - 1];
    }
}