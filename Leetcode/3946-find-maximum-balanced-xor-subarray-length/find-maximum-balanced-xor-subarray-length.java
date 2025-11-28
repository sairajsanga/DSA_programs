class Solution {
    public int maxBalancedSubarray(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0,0", -1);        
        int p = 0, b = 0, m = 0;
        for(int i = 0; i < nums.length; ++i) {
            p ^= nums[i];
            if(nums[i] % 2 == 0) ++b;
            else --b;
            String k = p + "," + b;
            if(map.containsKey(k)) {
                int pi = map.get(k);
                m = Math.max(m, i - pi);
            } 
            else map.put(k, i);
        }
        return m;
    }
}