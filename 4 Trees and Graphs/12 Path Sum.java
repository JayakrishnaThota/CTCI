import java.util.*;

public class PathSum {

    //O(n) time and space
    public int pathsum(TreeNode root, int target){
        return pathsum(root,0,target, new HashMap<Integer, Integer>());
    }

    public int pathsum(TreeNode root, int cursum, int target, HashMap<Integer, Integer> map){
        if(root==null) return 0;
        cursum+=root.val;
        int checksum = cursum - target;
        int totalpaths = map.getOrDefault(checksum, 0);
        if(cursum==target){
            totalpaths++;
        }
        increment(map,cursum,1);
        totalpaths+=pathsum(root.left,cursum,target,map);
        totalpaths+=pathsum(root.right,cursum,target,map);
        increment(map,cursum,-1);
        return totalpaths;
    }

    public void increment(HashMap<Integer, Integer> map, int key, int delta){
        int newcount = map.getOrDefault(key,0)+delta;
        if(newcount==0) map.remove(key);
        else map.put(key,newcount);
    }

}
