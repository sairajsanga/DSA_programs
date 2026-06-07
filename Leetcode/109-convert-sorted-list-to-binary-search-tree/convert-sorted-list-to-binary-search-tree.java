class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        List<Integer> arr = new ArrayList<>();

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        return build(arr, 0, arr.size() - 1);
    }

    private TreeNode build(List<Integer> arr, int l, int r) {
        if (l > r) return null;

        int mid = l + (r - l) / 2;

        TreeNode root = new TreeNode(arr.get(mid));

        root.left = build(arr, l, mid - 1);
        root.right = build(arr, mid + 1, r);

        return root;
    }
}