import java.util.Arrays;

/**
 * @ClassName xorQueries20210512
 * @Description TODO
 * @Author 22936
 * @Date 2021/5/12 9:16
 * @Version 1.0
 */

public class xorQueries20210512 {

    public static void main(String[] args) {
        xorQueries20210512 test = new xorQueries20210512();
        int[] arr = new int[]{1,3,4,8};
        int[][] queries =new int[][]{{0,1},{1,2},{0,3},{3,3}};
        System.out.println(Arrays.toString(test.xorQueries(arr,queries)));
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        //暴力法：时间复杂度O（m*n）
//        int[] ans = new int[queries.length];
//
//        for(int i = 0;i<queries.length;i++){
//            for(int j = queries[i][0];j<= queries[i][1];j++){
//                ans[i] ^= arr[j];
//            }
//        }
//
//        return ans;

        //前缀和：将时间复杂度优化为O（n）
        int n = arr.length;
        int[] xors = new int[n+1];
        for(int i = 1;i<=n;i++){
            xors[i] = xors[i-1] ^ arr[i-1];
        }

        int m = queries.length;
        int[] ans = new int[m];
        for(int i= 0;i<m;i++){
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }

        return ans;
    }
}
