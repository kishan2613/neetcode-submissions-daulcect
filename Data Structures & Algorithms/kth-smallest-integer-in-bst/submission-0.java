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
    public int kthSmallest(TreeNode root, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    preorder(root,pq);

    for(int i=0;i<k-1;i++){
        pq.poll();
    }

    return pq.peek();
    }
    public TreeNode preorder(TreeNode root,PriorityQueue<Integer> pq){
        if(root==null) return null;
        pq.add(root.val);
        preorder(root.left,pq);
        preorder(root.right,pq);

    return root;
    }
}
