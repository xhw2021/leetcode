import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Test
 * @Description 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * @Author 22936
 * @Date 2021/3/30 10:26
 * @Version 1.0
 */

/*
1.错误用例1：[10,2,9,39,17]   输出："92103917"   预期："93921710"
错误代码:
class Solution {
     public String largestNumber(int[] nums) {
        String[] ans = new String[nums.length];
        for(int i =0;i<nums.length;i++){
            ans[i] = String.valueOf(nums[i]);
        }

        for(int i=1;i<nums.length;i++){
            ans[i] = largest(ans[i-1],ans[i]);
        }
        return ans[nums.length - 1];
    }

    public String largest(String a,String b){
        if((a+b).compareTo(b+a) >= 0){
            return a+b;
        }else{
            return b+a;
        }
    }
}
错误原因：忽视了数字最高位对排序的影响，例如（2,9,39），用上述代码得到结果为：（2,9,39）-> (92,39)->(9239)
         正确的方法应先比较最高位，即（2,9,39）->(9,39,2)—>(9392)

2.错误用例2：[0,0]   输出："00"   预期："0"
错误原因：忽视了多个0的特殊情况，输出前提是整数，因此多个0仍为0。
*/



public class largestNumber20210412 {
    public static void main(String[] args) {
        largestNumber20210412 t = new largestNumber20210412();
        int[] nums = new int[]{10,2,9,39,17};
        System.out.println(t.largestNumber(nums));

    }

    public String largestNumber(int[] nums) {
        String[] ans = new String[nums.length];
        for(int i =0;i<nums.length;i++){
            ans[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(ans,(a,b)-> (b+a).compareTo(a+b));
        //lambda表达式缩写的是比较器函数
//        Arrays.sort(ans, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return ((b+a).compareTo(a+b));
//            }
//        });
        System.out.println("lamda表达式之后： "+ Arrays.toString(ans));

        StringBuilder out = new StringBuilder();
        for(int i=0;i<nums.length;i++){
           out.append(ans[i]);
        }
        String res = out.toString();
        return res.charAt(0) =='0'?"0":res ;
    }


}