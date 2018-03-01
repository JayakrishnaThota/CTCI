import java.util.*;

public class BSTSequences {

    public static ArrayList<LinkedList<Integer>> sequences(TreeNode root){
        ArrayList<LinkedList<Integer>> list = new ArrayList<>();
        if(root==null){
            list.add(new LinkedList<Integer>());
            return list;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.val);
        ArrayList<LinkedList<Integer>> leftSeq = sequences(root.left);
        ArrayList<LinkedList<Integer>> rightSeq = sequences(root.right);
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weavelists(left, right, weaved, prefix);
                list.addAll(weaved);
            }
        }
        return list;
    }

    public static void weavelists(LinkedList<Integer> left, LinkedList<Integer> right,  ArrayList<LinkedList<Integer>> weaved, LinkedList<Integer> prefix){
        if(left.size()==0 || right.size()==0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(left);
            result.addAll(right);
            weaved.add(result);
            return;
        }
        int leftfirst = left.removeFirst();
        prefix.addLast(leftfirst);
        weavelists(left,right,weaved,prefix);
        prefix.removeLast();
        left.addFirst(leftfirst);

        int rightfirst = right.removeFirst();
        prefix.addLast(rightfirst);
        weavelists(left,right,weaved,prefix);
        prefix.removeLast();
        right.addFirst(rightfirst);
    }
    
}
