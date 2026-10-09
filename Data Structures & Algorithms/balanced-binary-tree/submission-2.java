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
    int diff=0;
    public boolean isBalanced(TreeNode root) {
    int diff =helper(root);

    return diff!=-1?true:false;
    }

    public int helper(TreeNode root){
        if(root==null)return 0;

        int lh = helper(root.left);
        if(lh==-1)return -1;
        int rh = helper(root.right);
        if(rh==-1)return -1;

        if(Math.abs(rh-lh)>1){
            return -1;
        }

    return 1+Math.max(lh,rh);
    }
}
