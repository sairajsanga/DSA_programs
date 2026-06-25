class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int[] copy = nums;

        int n = nums.length;

        int validArrays = 0;

        for (int i = 0; i < n; i++) {
            int targetcount = 0;
            int othercount = 0;
            for (int j = i; j < n; j++) {
                if (copy[j] == target)
                    targetcount++;
                else
                    othercount++;
                if (targetcount >othercount)
                    validArrays++;
            }
        }

        return validArrays;
    }
}