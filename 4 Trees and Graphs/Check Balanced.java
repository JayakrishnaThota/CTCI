//O(n2) time and O(n) space
class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root);
    }
    public boolean helper(TreeNode root){
        if(root==null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1) return false;
        return helper(root.left)&&helper(root.right);
    }
    public int height(TreeNode node){
        if(node==null) return 0;
        return 1+Math.max(height(node.left), height(node.right));
    }
}
