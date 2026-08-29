import java.util.*;

public class Solution {

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static int[] parent;
    static int[] rank;

    // Find with path compression
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } 
        else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } 
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Store value + original index
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        // Sort according to value
        Arrays.sort(arr, (a, b) -> Integer.compare(a.value, b.value));

        /*
         * If two adjacent values in sorted order differ
         * by <= limit, they belong to the same component.
         */
        for (int i = 1; i < n; i++) {

            if ((long) arr[i].value - arr[i - 1].value <= limit) {
                union(arr[i].index, arr[i - 1].index);
            }
        }

        /*
         * Group indices and values according to their
         * connected component.
         */
        Map<Integer, List<Integer>> indices = new HashMap<>();
        Map<Integer, List<Integer>> values = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int root = find(i);

            indices.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
            values.computeIfAbsent(root, k -> new ArrayList<>()).add(nums[i]);
        }

        /*
         * For every component:
         *
         * smallest index  <- smallest value
         * second index     <- second smallest value
         * ...
         */
        int[] result = new int[n];

        for (int root : indices.keySet()) {

            List<Integer> idxList = indices.get(root);
            List<Integer> valueList = values.get(root);

            Collections.sort(idxList);
            Collections.sort(valueList);

            for (int i = 0; i < idxList.size(); i++) {
                result[idxList.get(i)] = valueList.get(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 3, 9, 8};
        int limit = 2;

        int[] result = lexicographicallySmallestArray(nums, limit);

        System.out.println(Arrays.toString(result));
    }
}