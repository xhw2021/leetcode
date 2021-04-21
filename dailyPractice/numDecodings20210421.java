import java.util.Arrays;

/**
 * @ClassName numDecodings20210421
 * @Description TODO
 * @Author 22936
 * @Date 2021/4/21 9:32
 * @Version 1.0
 */

public class numDecodings20210421 {

    public static void main(String[] args) {
        numDecodings20210421 test = new numDecodings20210421();
        String s = "2342532636387354363532138964521212113354351215";
        System.out.println(test.numDecodings(s));
    }

    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s; //加了空格后，会将数组的第二项和第三项置为0，后续dp的结果也全为0，因此前导0的字符串结果出了初始化的第一项外全为0.
        char[] cs = s.toCharArray();
        int[] f = new int[n+1];
        f[0] = 1;
        for(int i = 1;i<=n;i++){
            int a = cs[i] - '0';
            int b = (cs[i-1] - '0') * 10 + (cs[i] - '0');
            if(a>0 && a <= 9) f[i] = f[i-1];
            if(10 <= b && b <= 26) f[i] += f[i-2];
        }
        System.out.println(Arrays.toString(f));
        return f[n];

    }
}
