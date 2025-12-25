class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long sum = 0;
        for (int i = n - 1, dec = 0; i >= 0 && k > 0; i--, dec++) {
            sum += Math.max(happiness[i] - dec, 0);
            k--;
        }
        return sum;
    }
}