//Find the inorder and preorder of tree s
//Find the inorder and preorder of tree t
//A tree t is a subtree of another tree s if and only if both inorder and preorder of the tree t is a substring of s
//O(n) Time and space complexity
public class Solution{
  public boolean isSubtree(TreeNode s, TreeNode t){
    int[] ins = inorderTraversal(s);
    int[] pres = preorderTraversal(s);
    int[] int = inorderTraversal(t);
    int[] pret = preorderTraversal(t);
    return (isSubString(ins,int) && isSubString(pres,pret));
  }
    //O(n) time and space
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack();
        boolean done = false;
        TreeNode cur = root;
        while(!done){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                if(stack.isEmpty())
                    done = true;
                else{
                    cur = stack.pop();
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return list;
    }
    //O(n) time and space
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
        }
        return list;
    }
    //O(n) time and O(1) space
    public boolean isSubString(int[] a, int[] b){
      int i = 0, j = 0;
      int m = a.length;
      int n =b.length;
      for(;i<m-n;i++){
        if(a[i]==b[j]){
          j++;
          if(j==n) return true;
        }
        else{
          j=0;
        }
      }
    }
}
