/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    HashMap<Integer, List<Pair>> map;

    class Pair {
        int child;
        int isLeft;

        public Pair(int child, int isLeft) {
            this.child = child;
            this.isLeft = isLeft;
        }

        @Override
        public String toString() {
            return "(" + child + "," + isLeft + ")";
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {

        int n = descriptions.length;

        List<List<Integer>> adj = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int state[] : descriptions) {
            int parent = state[0];
            int child = state[1];
            int isLeft = state[2];

            set.add(parent);
        }

        int parentssize = set.size();
        this.map = new HashMap<>();

        for (int state[] : descriptions) {
            if (set.contains(state[1]))
                set.remove(state[1]);
        }

        if (set.size() < 1)
            return null;
        int rootval = 0;
        for (int val : set) {
            rootval = val;
            break;
        }

        for (int state[] : descriptions) {
            int parent = state[0];
            int child = state[1];
            int isLeft = state[2];

            map.computeIfAbsent(parent, (a) -> new ArrayList<Pair>()).add(new Pair(child, isLeft));
        }

        TreeNode root = new TreeNode(rootval);
        bfs(root);
        return root;
    }

    public void bfs(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                int val = curr.val;
                List<Pair> list = map.get(val);
                if (list != null) {
                    for (Pair p : list) {
                        TreeNode node = new TreeNode(p.child);
                        if (p.isLeft == 1) {
                            curr.left = node;
                            
                        } else {
                            curr.right = node;
                            
                        }
                        q.add(node);
                    }
                }

            }
        }

    }
}