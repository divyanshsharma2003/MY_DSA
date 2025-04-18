// Minimum energy of frog to reach to N stair. Energy = ht[i] - ht[i+1] or ht[i+2]
public class frogJump {
    static int fj(int n, int [] hts){
        int [] dp = new int[n+1];
        dp[0]=0;
        int jump1 = 0;
        int jump2 = Integer.MAX_VALUE;
        for(int i =1;i<=n;i++){
            jump1 = dp[i-1] + Math.abs(hts[i] - hts[i-1]);
            if(i>1){
                jump2 = dp[i-2] + Math.abs(hts[i] - hts[i-2]);
            }
            dp[i] = Math.min(jump1, jump2);
        }
        return dp[n];
    }
    static int fj_space_opt(int n, int[] hts){
        int prev1 =0;
        int prev2 = 0;
        int curri=0;
        for(int i=1;i<n;i++){
           int jump1 = prev1 + Math.abs(hts[i] - hts[i-1]);
           int jump2 = Integer.MAX_VALUE;
            if(i>1){
                jump2 = prev2 + Math.abs(hts[i] - hts[i-2]);
            }
            curri = Math.min(jump1, jump2);
            prev2 = prev1;
            prev1 = curri;
        }
        return prev1;
    }
    public static void main(String []args){
        int hts[] = {30, 10, 60, 10, 60, 50};
        int n = hts.length;
        System.out.println("Minimum Energy : "+fj_space_opt(n, hts));
    }
}
