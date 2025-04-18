import java.util.Arrays;

public class knapsack01 {
    static int solve(int idx,int maxWeight, int [] weight, int[]value, int[][]dp){
        if(idx == 0){
            if(weight[0] <= maxWeight) return value[0];
            return 0;
        }
        if(dp[idx][maxWeight] != -1)return dp[idx][maxWeight];
        int notTake = 0+solve(idx-1,maxWeight, weight, value, dp);
        int take = Integer.MIN_VALUE;
        if(weight[idx] <= maxWeight){
            take = value[idx]+solve(idx-1, maxWeight-weight[idx], weight, value, dp);
        }
        return dp[idx][maxWeight] = Math.max(notTake, take);
    }
    static int knpsck(int []weight, int[]value,int maxWeight, int n){
        int [][]dp = new int[n][maxWeight+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(n-1,maxWeight,weight, value,dp);
    }
    public static void main(String[]args){
        int n = 4;
        int [] weight = {1,2,4,5};
        int[] value = {5,4,8,6};
        int maxWeight = 5;
        System.out.println(knpsck(weight, value, maxWeight, n));
    }
}
