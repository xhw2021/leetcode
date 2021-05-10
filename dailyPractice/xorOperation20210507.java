/**
 * @ClassName xorOperation20210507
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/7 9:18
 * @Version 1.0
 */

public class xorOperation20210507 {

    public static void main(String[] args) {
        xorOperation20210507 test = new xorOperation20210507();
        int n = 10;
        int start = 5;
        System.out.println(test.xorOperation(n,start));

    }

    public int xorOperation(int n, int start) {
        int ans = 0;
        for(int i = 0;i<n;i++){
            int a = start + 2 * i;
            ans ^= a;
        }
        return ans;
    }
}
