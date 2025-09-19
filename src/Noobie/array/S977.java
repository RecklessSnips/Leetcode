package Noobie.array;

import java.util.Arrays;

public class S977 {

    public static int[] sortedSquares(int[] nums) {
        // 先平方之后然后进行sort
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i]; // 或 nums[i] = nums[i] ^ 2 如果你真要用异或
        }

        Arrays.sort(nums);

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
