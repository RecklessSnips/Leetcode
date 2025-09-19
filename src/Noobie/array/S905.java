package Noobie.array;

import java.util.Arrays;

public class S905 {

    public static int[] sortArrayByParity(int[] nums) {
        if (nums.length < 2) return nums;

        // 方法1
//        int odd = 0, even = 0;

//        while (odd < nums.length && even < nums.length) {
//            // 找下一个奇数, 不是奇数就跳过
//            while (odd < nums.length && nums[odd] % 2 == 0) {
//                odd++;
//            }
//
//            // 找下一个偶数（必须在奇数右边）
//            /*
//            nums[even] % 2 != 0
//            说明当前 even 指针指向的是奇数 → 不符合“偶数”的要求 → 要继续往右找。
//
//            even <= odd
//            说明即便当前是偶数，它也在 odd 指针的左边或相同位置（交换没意义或会覆盖） → 要继续往右找。
//             */
//            while (even < nums.length && (nums[even] % 2 != 0 || even <= odd)) {
//                even++;
//            }
//
//            // 因为每一轮会自动寻找下一个奇偶数，所以要小心之前判断过的数还继续交换
//            // 比如 {3, 2, 4, 1} 交换完后 odd 或者 even 还没有到达最后，但是已经交换完了，需要截断
//            if (odd < nums.length && even < nums.length) {
//                int tmp = nums[odd];
//                nums[odd++] = nums[even];
//                nums[even++] = tmp;
//            }
//        }

        // 方法2
        /*
        双指针，一个在前一个在后，
        左指针停在奇数，右指针停在偶数时 → 交换
        left 永远指向第一个奇数
        */
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                // 找到之后与left交换，并且更新left的位置, 只换偶数！
                int tmp = nums[left];
                nums[left] = nums[i];
                nums[i] = tmp;
                left++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3,1,2,4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 2, 4, 1})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0, 1})));
    }
}
