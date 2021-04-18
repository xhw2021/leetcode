import java.util.Arrays;

/**
 * @Author: 22936
 * @CreateTime: 2021-04-18 16:27
 * @Description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class removeDuplicates20210418 {

    public static void main(String[] args) {
        removeDuplicates20210418 test = new removeDuplicates20210418();
        int[] nums = new int[]{1,1,2};
        System.out.println(test.removeDuplicates(nums));

    }

    public int removeDuplicates(int[] nums) {
        int i = 0; // 慢指针
        if(nums.length == 0){
            return 0;
        }
        for(int j = 1;j<nums.length;j++){  //快指针
            if(nums[j] != nums[i]){
                i += 1;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i+1;
    }
}
