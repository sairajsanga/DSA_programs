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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;


        solve(root,targetSum,new ArrayList<>(),res);
        return res;
    }

    public void solve(TreeNode root,int targetSum,List<Integer> list,List<List<Integer>> res){
        if(root==null) return;

        if(root.left==null&&root.right==null&& targetSum==root.val){
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.removeLast();  
            return;
        } 

        list.add(root.val);
        solve(root.left,targetSum-root.val,list,res);
        solve(root.right,targetSum-root.val,list,res);
        list.removeLast();

    }
}