class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> vis = new HashSet<>();
        String smallest = s;
        Deque<String> q = new ArrayDeque<>();
        q.offer(s);
        vis.add(s);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(smallest) < 0)
                smallest = cur;

            char arr[] = cur.toCharArray();
            int n = arr.length;
            for (int i = 1; i < n; i += 2) {
                int num = (arr[i] - '0');
                num = (num + a) % 10;
                arr[i] = (char) (num + '0');
            }
            String added = new String(arr);
            if (vis.add(added))
                q.offer(added);

            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (vis.add(rotated))
                q.offer(rotated);
        }
        return smallest;
    }
}