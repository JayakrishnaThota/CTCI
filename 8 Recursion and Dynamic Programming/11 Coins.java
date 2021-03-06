public class Solution {
    public int coinchange2(ArrayList<Integer> A, int n) {
        if(A==null || A.size()==0) return 0;
        int[] coins = new int[A.size()];
        for(int i=0;i<coins.length;i++)
        coins[i] = A.get(i);
         long[] table = new long[n+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i=0; i<A.size(); i++)
            for (int j=coins[i]; j<=n; j++){
                table[j] += table[j-coins[i]];
            }
 
        return (int)table[n];
    }
}
