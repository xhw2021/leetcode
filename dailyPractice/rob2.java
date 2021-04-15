/**
 * @ClassName rob2
 * @Description TODO
 * @Author 22936
 * @Date 2021/4/15 10:11
 * @Version 1.0
 */

public class rob2 {

    public static void main(String[] args) {
        rob2 test = new rob2();
        System.out.println(test.rob(new int[]{2,3,2}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(robRange(nums,0,n-2),robRange(nums,1,n-1));
    }

    public int robRange(int[] nums,int start,int end){
        int n = nums.length;
        int dp_i1= 0,dp_i2 = 0;
        int dp_i = 0;
        for(int i = end;i >= start;i--){
            dp_i = Math.max(dp_i1,nums[i] + dp_i2);
            dp_i2 = dp_i1;
            dp_i1 = dp_i;
        }

        return dp_i;
    }

}
