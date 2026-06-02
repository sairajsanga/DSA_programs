class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;

        for (int num : nums)
            sum += num;

        if (sum % k != 0)
            return false;

        int target = sum / k;

        Arrays.sort(nums);

        if (nums[nums.length - 1] > target)
            return false;

        boolean[] visited = new boolean[nums.length];

        return dfs(nums, visited, k, 0, 0, target);
    }

    private boolean dfs(int[] nums,
            boolean[] visited,
            int k,
            int start,
            int currSum,
            int target) {

        if (k == 1)
            return true;

        if (currSum == target)
            return dfs(nums, visited, k - 1, 0, 0, target);

        for (int i = start; i < nums.length; i++) {

            if (visited[i])
                continue;

            if (currSum + nums[i] > target)
                continue;

            visited[i] = true;

            if (dfs(nums,
                    visited,
                    k,
                    i + 1,
                    currSum + nums[i],
                    target))
                return true;

            visited[i] = false;

            // if(currSum==0) break;
        }

        

        return false;
    }
}