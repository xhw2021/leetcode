/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 10:34
 * @Description: 整数反转
 */
public class reverse20210503 {

    public static void main(String[] args) {
        reverse20210503 test = new reverse20210503();
        int x = 123;
        System.out.println(test.reverse(x));

    }

    public int reverse(int x) {
        int ans = 0;
        while (x != 0){
            int lastDigit = x%10;
            x = x/10;
            /*
            1.注意考虑边界的溢出情况，以8位系统为例（-128 - 127）, 对于117来说不溢出，但是反过                来711就溢出了；
            2. integer的最大值最小值可以直接调用内置常数表示。
            */
            if ((ans > Integer.MAX_VALUE/10)||(ans == Integer.MAX_VALUE/10 && x > 7)) return 0;
            if ((ans < Integer.MIN_VALUE/10)||(ans == Integer.MIN_VALUE/10 && x <-8)) return 0;
            ans = ans * 10 + lastDigit;
        }
        return ans ;
    }
}
