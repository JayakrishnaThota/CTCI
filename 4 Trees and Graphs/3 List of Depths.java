import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left,right;
    public TreeNode(int val){
        this.val = val;
    }
}

public class ListOfDepths {

    public static List<List<Integer>> depth(TreeNode root){
        List<List<Integer>> list = new ArrayList();
        if(root==null) return list;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> sublist = new ArrayList();
            for(int i=0;i<level;i++){
                TreeNode temp = q.poll();
                sublist.add(temp.val);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            list.add(sublist);
        }
        return list;

    }

    public static void display(List<List<Integer>> list){
        for(List<Integer> sublist:list){
            for(Integer node:sublist){
                System.out.print(node+"->");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);root.right.right = new TreeNode(7);
        List<List<Integer>> result = depth(root);
        display(result);
    }
}
