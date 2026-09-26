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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int d=depth(root);

        return solve(root,0,d-1);
    }

    public TreeNode solve(TreeNode root,int level,int d){
       if(root==null) return null;

       if(root.left==null&&root.right==null){
          if(level==d) return root;
          return null;
       }

        TreeNode left=solve(root.left,level+1,d);
        TreeNode right=solve(root.right,level+1,d);

        if(left!=null&&right!=null) return root;

        return left!=null?left:right;
    }

    public int depth(TreeNode root){
        if(root==null) return 0;

       return 1+Math.max(depth(root.left),depth(root.right));
    }

    
}