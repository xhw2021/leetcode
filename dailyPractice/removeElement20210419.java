/**
 * @ClassName removeElement20210419
 * @Description 给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
 *  并返回移除后数组的新长度。不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修
 *  改输入数组。元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @Author 22936
 * @Date 2021/4/19 9:29
 * @Version 1.0
 */
//典型的双指针问题，采用快指针循环，慢指针修改数据的方法。
public class removeElement20210419 {

    public static void main(String[] args) {
        removeElement20210419 test = new removeElement20210419();
        System.out.println(test.removeElement(new int[]{3,2,2,3},3));
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;  //慢指针
        for(int j = 0;j<nums.length;j++){  //快指针
            if(nums[j] != val){
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }
}
