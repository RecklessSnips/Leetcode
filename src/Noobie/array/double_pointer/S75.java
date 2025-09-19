package Noobie.array.double_pointer;

import java.util.Arrays;

public class S75 {

    public static void sortColors(int[] nums) {
        // nums = [2,0,1]
        /*
        利用双指针，来制定左右两边，也就是0和2的插入位置，再来一个变量i来记录当前数字的位置
        if i == 2: 与 right 指针交换位置, 然后 right--
        if i == 0: 与 left 指针交换位置, 然后 left++
        if i == 1: left和right不变，i++, 跟后面的来换即可
        当 i 碰到right的时候就说明已经交换完成了
         */
        int left = 0;
        int right = nums.length - 1;
        int curr = left;
        while (curr <= right){
            if (nums[curr] == 2){
                int tmp = nums[curr];
                nums[curr] = nums[right];
                nums[right] = tmp;

                right--;
//                curr++; 因为不知道右边换过来的是1还是0，所以下一次循环再判断一次
            } else if (nums[curr] == 0) {
                int tmp = nums[curr];
                nums[curr] = nums[left];
                nums[left] = tmp;

                left++;
                curr++;
            }else{
                curr ++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
        sortColors(new int[]{2,0,1});
        sortColors(new int[]{1, 2, 0});
    }
}
