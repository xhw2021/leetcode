import java.util.Arrays;

/**
 * @ClassName numWays20210513
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/13 9:23
 * @Version 1.0
 */

public class numWays20210513 {

    public static void main(String[] args) {
        int steps = 3;
        int arrLen = 2;
        numWays20210513 test = new numWays20210513();
        System.out.println(test.numWays(steps,arrLen));
    }


    public int numWays(int steps, int arrLen) {
        int mod =(int)Math.pow(10,9) + 7;
        int maxColumns = Math.min(arrLen-1,steps);
        int[][] dp = new int[steps + 1][maxColumns + 1];
        dp[0][0]  = 1;
        for(int i = 1;i <= steps;i++){
            for(int j = 0;j<= maxColumns;j++){
                dp[i][j] = dp[i-1][j]; //第0列填入数字
                if(j-1 >= 0 ){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-1])%mod;
                }
                if(j+1 <= maxColumns){
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1]) %mod;
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[steps][0];
    }
}
