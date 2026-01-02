package CodeForces;

import java.util.HashMap;

class biweekly {

    public static int minOperations(int[] nums) {
        int n = nums.length;

        if (n < 2) return 0;

        // Frequency map for suffix
        HashMap<Integer, Integer> freq = new HashMap<>();
        int duplicates = 0;

        // Build initial suffix
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) == 2) duplicates++;
        }

        // If already distinct
        if (duplicates == 0) return 0;

        int operations = 0;

        // Remove elements in chunks of 3 (your logic)
        for (int i = 0; i < n; i += 3) {
            operations++;

            // Remove 3 elements from suffix
            for (int j = i; j < i + 3 && j < n; j++) {
                int val = nums[j];
                int count = freq.get(val);

                if (count == 2) duplicates--; // duplicate resolved
                freq.put(val, count - 1);
            }

            if (duplicates == 0) return operations;
        }

        return operations;
    }

    public static void main(String[] args) {
        int nums[] = {100,4,13,12,92,25,23,63,38,82,15,19,74,85,56,13,13};
        System.out.println(minOperations(nums));
    }
}
