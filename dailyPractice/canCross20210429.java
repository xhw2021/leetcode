import java.util.Arrays;

/**
 * @ClassName canCross20210429
 * @Description TODO
 * @Author 22936
 * @Date 2021/4/29 9:44
 * @Version 1.0
 */

public class canCross20210429 {
    public static void main(String[] args) {
        canCross20210429 test = new canCross20210429();
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        System.out.println(test.canCross(stones));
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(stones[1] != 1) return false;
        boolean[][] dp = new boolean[n][n];
        dp[1][1] = true;
        for(int i = 2;i<n;i++){
            for(int j = 1;j<i;j++){
                int k = stones[i] - stones[j];
                if(k <= j+1){
                    dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        for(int i = 1;i<n;i++){
            if(dp[n-1][i]) return true;

        }

        return false;
    }




}
