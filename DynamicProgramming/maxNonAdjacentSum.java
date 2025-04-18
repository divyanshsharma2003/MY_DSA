// Maximum sum of two non adjacent elements of an array.

import java.util.Arrays;

public class maxNonAdjacentSum {
    static int sum_memoization(int idx, int [] arr, int[]dp){ //Memoization
        if(idx == 0)return arr[idx];
        if(idx<0)return 0;
        if(dp[idx] != -1) return dp[idx];
        int pick = arr[idx] + sum_memoization(idx-2, arr, dp);
        int notPick = 0 + sum_memoization(idx-1, arr, dp);
        return dp[idx] = Math.max(pick, notPick);
    }
    static int sum_tabulation(int idx, int []arr){ //Tabulation(Space Optimized ->No dp, Two variables used)
        int prev1 = arr[0];
        int prev2 = 0;
        for(int i=1;i<=idx;i++){
            int take = arr[i];
            if(i>1) take += prev2;
            int notTake = 0 + prev1;
            int curri = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curri;
        }
        return prev1;
    }
    public static void main(String[] args){
        int [] arr ={2,1,4,9};
        int n = arr.length-1;
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(sum_tabulation(n, arr));
    }
}
