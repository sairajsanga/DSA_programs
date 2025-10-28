class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return nums;
        int[] res = new int[n - k + 1];
        Arrays.fill(res, -1);

        int consecutive = 1; // length of current consecutive sequence
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                consecutive++;
            } else {
                consecutive = 1;
            }
            if (i >= k - 1 && consecutive >= k) {
                res[i - k + 1] = nums[i]; // last element is max
            }
        }
        return res;
    }
}