import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: 22936
 * @CreateTime: 2021-04-11 21:10
 * @Description: 给你一个整数 n ，请你找出并返回第 n 个 丑数 。  丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class nthUglyNumber20210411 {
    public static void main(String[] args) {
        nthUglyNumber20210411 test = new nthUglyNumber20210411();
        int n = 10;
        System.out.println(test.nthUglyNumber1(n));
        System.out.println(test.nthUglyNumber2(n));
    }
/*
动态规划解法：空间复杂度 o(n)  时间复杂度O(n)
易错点：忽略丑数的构成条件，误认为丑数是2,3,5的倍数，因此只用倍数来表示丑数
，实际应该为丑数的2,3,5倍。
*/
    public int nthUglyNumber1(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int a = 0,b =0,c=0;
        for(int i = 1;i<n;i++){
            int n1 = dp[a] * 2;
            int n2 = dp[b] * 3;
            int n3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n1,n2),n3);
            if(dp[i] == n1)  a++;
            if(dp[i] == n2)  b++;
            if(dp[i] == n3)  c++;
        }
        return dp[n-1];
    }
/*
向优先队列中添加元素的复杂度为O(logn)，因此总的复杂度为O(nlogn)
空间复杂度为O(n)

*/
    public int nthUglyNumber2(int n) {
       int[] nums = new int[]{2,3,5};
       Set<Long> set = new HashSet<>();
       Queue<Long> pq = new PriorityQueue<>();
       set.add(1L);
       pq.add(1L);
       for(int i = 1;i<=n;i++){
           long x = pq.poll();
           if(i == n)  return (int) x;
           for(int num :nums){
               long t = num * x;
               if(!set.contains(t)){
                   set.add(t);
                   pq.add(t);
               }
           }
       }
       return -1;
    }
}
