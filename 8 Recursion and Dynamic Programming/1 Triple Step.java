import java.util.*;
public class TripleStep {

    //O(n) time and O(n) Space
    public int countWays(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        return helper(n,dp);
    }

    public int helper(int n, int[] dp){
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        else{
            dp[n] = dp[n-1]+dp[n-2]+dp[n-3];
            return dp[n];
        }
    }

}
