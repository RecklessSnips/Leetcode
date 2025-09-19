package Noobie.array;

import java.util.Arrays;

public class M283 {

    public static void moveZeroes(int[] nums) {
        int p = 0;
        // 方法1，使用p作为第一个 0 的位置，每次遇到一个非 0，跟 p 交换位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != p) { // 只有当 i 和 p 不同才需要移动和清零
                    nums[p] = nums[i];
                    nums[i] = 0;
                }
                p++;
            }
        }

        System.out.println(Arrays.toString(nums));

        // 方法2，直接将所有的非 0 依次插入， 然后依次补0
//        int p = 0;
//        // 把非零元素依次放到前面
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[p++] = nums[i];
//            }
//        }
//        // 后面补零
//        while (p < nums.length) {
//            nums[p++] = 0;
//        }

    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes(new int[]{0,1,1,3,12});
        moveZeroes(new int[]{0});
        moveZeroes(new int[]{1});
    }
}
