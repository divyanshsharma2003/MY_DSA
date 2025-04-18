// Frog Jump with K distances using Memoization.
import java.util.*;
public class frogJump_k {
    static int f(int k, int idx, int [] hts,int [] dp){
        if(idx==0)return 0;
        if(dp[idx] != -1) return dp[idx];
        int minEnergy = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(idx-j>=0){
                int jump1 = f(k, idx-j, hts, dp)+Math.abs(hts[idx]-hts[idx-j]);
                minEnergy = Math.min(minEnergy, jump1);
            }
        }
        return dp[idx] = minEnergy;
    }
    public static void main(String [] args){
        int hts[] = {10, 20, 30, 10};
        int idx = hts.length-1;
        int k =2;
        int [] dp = new int [idx+1];
        Arrays.fill(dp, -1);
        System.out.println("Min Energy : "+f(k, idx, hts, dp));
    }
}
