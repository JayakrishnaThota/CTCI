import java.util.*;
public class SumPair {
    public List<List<Integer>> findPairs(int[] array, int target){
        int n = array.length;
        Set<Integer> set = new HashSet();
        List<List<Integer>> result = new ArrayList();
        for(int a:array){
            int b = target-a;
            if(set.contains(b)){
                List<Integer> temp = new ArrayList();
                temp.add(a);
                temp.add(b);
                result.add(temp);
            }
            set.add(a);
        }
        return result;
    }

    public void display(List<List<Integer>> list){
        for(List<Integer> sublist:list){
            System.out.println("[" + sublist.get(0)+","+sublist.get(1)+"]");
        }
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,9,-1,-8};
        SumPair s = new SumPair();
        List<List<Integer>> result = s.findPairs(array,1);
        s.display(result);
    }
}
