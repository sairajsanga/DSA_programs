import java.util.*;

public class JobProfitMaximizer {

    static class Job {
        int index, profit, prerequisite;
        public Job(int index, int profit, int prerequisite) {
            this.index = index;
            this.profit = profit;
            this.prerequisite = prerequisite;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // Number of jobs
        int S = sc.nextInt(); // Initial money

        Job[] jobs = new Job[N + 1]; // index from 1 to N
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            int profit = sc.nextInt();
            int prerequisite = sc.nextInt();
            jobs[i] = new Job(i, profit, prerequisite);
            if (prerequisite != 0) {
                graph.get(prerequisite).add(i);
                inDegree[i]++;
            }
        }

        // Topological sort (Kahn's algorithm)
        Queue<Integer> queue = new LinkedList<>();
        int[] maxMoney = new int[N + 1]; // max money after completing job i
        boolean[] completed = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0 && S + jobs[i].profit >= 0) {
                queue.add(i);
                maxMoney[i] = S + jobs[i].profit;
            }
        }

        int maxResult = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (completed[curr]) continue;

            completed[curr] = true;
            int currMoney = maxMoney[curr];
            maxResult = Math.max(maxResult, currMoney - S); // profit gained so far

            for (int next : graph.get(curr)) {
                inDegree[next]--;
                int nextProfit = jobs[next].profit;
                int newMoney = currMoney + nextProfit;

                if (inDegree[next] == 0 && newMoney >= 0) {
                    maxMoney[next] = newMoney;
                    queue.add(next);
                }
            }
        }

        System.out.println(maxResult);
    }
}
