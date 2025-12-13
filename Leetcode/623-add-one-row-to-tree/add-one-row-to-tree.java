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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null) return null;
        if(depth==1){
            TreeNode newroot=new TreeNode(val);
            newroot.left=root;
            return newroot;
        }

        return dfs(root,val,1,depth);
    }
    public TreeNode dfs(TreeNode root,int val,int currdepth,int depth){
        if (root == null)
            return null;
        if(currdepth==depth-1){
            TreeNode lefttemp=root.left;
            TreeNode righttemp=root.right;

            root.left=new TreeNode(val);
            root.right=new TreeNode(val);

            root.left.left=lefttemp;
            root.right.right=righttemp;
            return root;
        }  

        root.left=dfs(root.left,val,currdepth+1,depth);
        root.right=dfs(root.right,val,currdepth+1,depth);
        return root;  
       
    }
}