import java.util.Arrays;

/**
 * @ClassName decode20210506
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/6 10:07
 * @Version 1.0
 */

public class decode20210506 {
    public static void main(String[] args) {

        decode20210506 test = new decode20210506();
        int[] encoded = new int[]{6,2,7,3};
        int first = 4;
        System.out.println(Arrays.toString(test.decode(encoded,first)));

    }

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;

        int[] decoded = new int[n+1];

        decoded[0] = first;

        for(int i = 1;i<=n;i++){
            decoded[i] = encoded[i-1] ^ decoded[i-1];
        }

        return decoded;

    }
}
