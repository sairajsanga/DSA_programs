class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            max = Math.max(max, nums[i]);
        }
        
        boolean[] isPrime = sieve(max);
        boolean[] visited = new boolean[n];
        Set<Integer> usedPrime = new HashSet<>();
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0], steps = cur[1];
            if (idx == n - 1) return steps;
            
            // Adjacent moves
            if (idx - 1 >= 0 && !visited[idx - 1]) {
                visited[idx - 1] = true;
                q.offer(new int[]{idx - 1, steps + 1});
            }
            if (idx + 1 < n && !visited[idx + 1]) {
                visited[idx + 1] = true;
                q.offer(new int[]{idx + 1, steps + 1});
            }
            
            // Prime teleportation
            int val = nums[idx];
            if (isPrime[val] && !usedPrime.contains(val)) {
                usedPrime.add(val);
                for (int mul = val; mul <= max; mul += val) {
                    if (map.containsKey(mul)) {
                        for (int nextIdx : map.get(mul)) {
                            if (!visited[nextIdx]) {
                                visited[nextIdx] = true;
                                q.offer(new int[]{nextIdx, steps + 1});
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}