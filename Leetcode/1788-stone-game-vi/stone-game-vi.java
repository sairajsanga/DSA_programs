class Solution {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {

        int n = aliceValues.length;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < n; i++) {
            q.offer(new int[] { i, aliceValues[i] + bobValues[i] });
        }

        int aliceScore = 0;
        int bobScore = 0;
        int person = 1;
        boolean visited[] = new boolean[n];

        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int val = curr[1];
            int index = curr[0];

            if (person == 1) {
                if (visited[index])
                    continue;
                aliceScore += aliceValues[index];
                visited[index] = true;
                person = 0;

            } else {
                if (visited[index])
                    continue;
                bobScore += bobValues[index];
                visited[index] = true;
                person = 1;
            }
        }

        if (aliceScore > bobScore)
            return 1;
        else if (aliceScore < bobScore)
            return -1;
        else
            return 0;
    }
}