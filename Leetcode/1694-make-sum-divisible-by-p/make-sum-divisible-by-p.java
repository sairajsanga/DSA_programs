class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) total += num;
        int rem = (int)(total % p);
        if (rem == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefix mod 0 at index -1
        long prefix = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int target = (int)((prefix - rem + p) % p);
            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
            }
            map.put((int)prefix, i);
        }
        return res == nums.length ? -1 : res;
    }
}