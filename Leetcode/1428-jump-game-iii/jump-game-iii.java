class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int idx = q.poll();

            if (idx < 0 || arr[idx] < 0 || idx >= n)
               continue;

            if (arr[idx] == 0)
                return true;

            int jumpidx = arr[idx];
            arr[idx] = -1;

            int right = idx + jumpidx;
            int left = idx - jumpidx;
            if (right >= 0 && right < n && arr[right] >= 0) {
                q.offer(right);
            }

            if (left >= 0 && arr[left] >= 0 && left < n) {
                q.offer(left);
            }

        }

        return false;
    }
}