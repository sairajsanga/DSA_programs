class Solution {
    public int countSpecialIntegers(int[] nums) {

        int n = nums.length;

        int freq[] = new int[101];

        // Frequency of every number
        for (int num : nums) {
            freq[num]++;
        }

        int first[] = new int[101];
        int last[] = new int[101];

        Arrays.fill(first, -1);

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {

            int num = nums[i];

            if (first[num] == -1) {
                first[num] = i;
            }

            last[num] = i;
        }

        int count = 0;

        for (int num = 1; num <= 100; num++) {

            if (freq[num] == 0) {
                continue;
            }

            int length = last[num] - first[num] + 1;

            if (length == freq[num]) {
                count++;
            }
        }

        return count;
    }
}