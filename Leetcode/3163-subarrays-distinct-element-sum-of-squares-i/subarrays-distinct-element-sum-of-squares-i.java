class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();

        int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(arr[j]);
                int s = set.size();      
                ans += s * s;
            }    
        }

        return ans;

    }
}