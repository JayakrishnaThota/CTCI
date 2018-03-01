/O(n) time and space
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<Integer> list = inorderTraversal(root);
        if(list==null || list.get(list.size()-1)==p.val) return null;
        int index = 0;
        for(int i=0;i<list.size()-1;i++)
            if(list.get(i)==p.val) { index = i; break; }
        return new TreeNode(list.get(index+1));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        boolean done = false;
        while(!done)
        {
            if(curr!=null) { stack.push(curr); curr = curr.left; }
            else if(stack.isEmpty()) done = true;
            else
            {
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }
        return list;
    }
}
