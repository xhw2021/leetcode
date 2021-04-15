import java.util.Arrays;

/**
 * @ClassName rob1
 * @Description TODO
 * @Author 22936
 * @Date 2021/4/15 9:45
 * @Version 1.0
 */

public class rob1 {

    public static void main(String[] args) {
        rob1 test = new rob1();
        System.out.println(test.rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }

    private int[] memo;

    public int rob(int[] nums){
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return dp(nums,0);
    }

    private int dp(int[] nums,int start){
        if(start >= nums.length) return 0;

        if(memo[start] != -1) return memo[start];

        int res = Math.max(dp(nums,start+1),nums[start] + dp(nums,start + 2));
        memo[start] = res;

        return res;
    }

}
