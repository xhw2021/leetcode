/**
 * @ClassName judgeSquareSum
 * @Description TODO
 * @Author 22936
 * @Date 2021/4/28 15:35
 * @Version 1.0
 */

public class judgeSquareSum20210428 {
    public static void main(String[] args) {
        judgeSquareSum20210428 test = new judgeSquareSum20210428();
        int c = 1;
        System.out.println(test.judgeSquareSum(c));
    }

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);

        while(left <= right){
            if((left*left+right*right) == c) {
                return true;
            }else if((left*left+right*right) < c) {
                left ++;
            }else{
                right--;
            }
        }
        return false;
    }

}
