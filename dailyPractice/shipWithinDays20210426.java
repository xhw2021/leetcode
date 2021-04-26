import java.util.Arrays;

/**
 * @ClassName shipWithinDays20210426
 * @Description 二分法的实际应用，左边界和右边界的确定灵活，第一时间内不容易想出。
 * @Author 22936
 * @Date 2021/4/26 9:40
 * @Version 1.0
 */

public class shipWithinDays20210426 {

    public static void main(String[] args) {
        shipWithinDays20210426 test = new shipWithinDays20210426();
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(test.shipWithinDays(weights,D));

    }

    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while(left < right){
            int mid = (left + right) / 2;
            int need = 1; //运输的天数
            int cur = 0;
            for(int weight:weights){
                if(cur + weight > mid){
                    need ++ ;
                    cur = 0;
                }
                cur += weight;
            }

            if(need <= D){
                right = mid;
            }else{
                left = mid +1;
            }
        }

        return left;
    }
}
