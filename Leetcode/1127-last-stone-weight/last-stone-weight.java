class Solution {
    public int lastStoneWeight(int[] stones) {
        // Max-heap: largest element at the head
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            q.add(stone); // insert actual stone weights
        }
        // Smash the two largest stones until one or none remains
        while (q.size() > 1) {
            int y = q.poll(); // largest
            int x = q.poll(); // second largest
            if (y != x) {
                q.add(y - x); // difference, if not equal
            }
        }
        // If no stone left, return 0; else return remaining stone
        return q.isEmpty() ? 0 : q.peek();
    }
}
