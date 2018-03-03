import java.util.*;
public class SumSwap {
    int[] result = new int[2];
    public boolean swap(int[] a, int[] b){
        //Assume a has the smallest sum and b has the largest sum
        int asum = 0, bsum=0;
        for(int i:a) asum+=i;
        for(int i:b) bsum+=i;
        int diff = bsum-asum;
        //Put all the elements of a in the hashset
        Set<Integer> set = new HashSet();
        for(int i:a) set.add(i);
        for(int i:b){
            int target = i-diff;
            if(set.contains(target)){
                result[0] = target;
                result[1] = i;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int A[] = { 4, 1, 2, 1, 1, 2 };
        int B[] = { 3, 6, 3, 3 };
        SumSwap s = new SumSwap();
        int asum=0,bsum=0;
        for(int a:A) asum+=a;
        for(int b:B) bsum+=b;
        boolean r = false;
        if(asum>bsum){
            r = s.swap(B,A);
        }
        else{
            r = s.swap(A,B);
        }
        if(r){
            System.out.println("The two values are"+s.result[0]+","+s.result[1]);
        }
    }
}

