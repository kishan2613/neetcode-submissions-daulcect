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

public class Codec {
     private int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        preorder(root,res);
        String ans = String.join(",", res);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = 0;

    return build(arr);
    }

    public void preorder(TreeNode root, ArrayList<String> path){
        if(root==null){
            path.add("null");
            return ;
        };

        path.add(String.valueOf(root.val));
        preorder(root.left,path);
        preorder(root.right,path);
    }   

    private TreeNode build(String[] arr) {

    if (arr[index].equals("null")) {
        index++;
        return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));

    root.left = build(arr);
    root.right = build(arr);

    return root;
}
}
